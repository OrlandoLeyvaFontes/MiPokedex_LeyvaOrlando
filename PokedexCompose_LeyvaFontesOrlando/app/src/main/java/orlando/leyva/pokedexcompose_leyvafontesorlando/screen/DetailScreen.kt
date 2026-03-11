package orlando.leyva.pokedexcompose_leyvafontesorlando.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import orlando.leyva.pokedexcompose_leyvafontesorlando.R
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.Ability
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.Chip
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.PokemonNavigator
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.Pokemon
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.getNeighbors
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.getPokemon
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.ElectricYellow
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.White

@Composable
fun DetailScreen(pokemonId: Int, onNavigateBack: () -> Unit, onNavigateTo: (Int) -> Unit) {
    val pokemon = getPokemon(pokemonId)

    if (pokemon != null) {
        val neighbors = getNeighbors(pokemonId)

        Column(
            modifier = Modifier
                .background(ElectricYellow, shape = RectangleShape)
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(bounded = false),
                            onClick = onNavigateBack
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp),
                        tint = Color.Black
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = pokemon.name.uppercase(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                    Text(
                        text = "#${pokemon.number.toString().padStart(3, '0')}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.7f)
                    )
                }

                Box(modifier = Modifier.size(48.dp), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(
                            if (pokemon.fav) R.drawable.star_filled else R.drawable.star_outline
                        ),
                        contentDescription = if (pokemon.fav) "Favorito" else "No favorito",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            // Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                PokemonCard(pokemon) { evolutionId ->
                    onNavigateTo(evolutionId)
                }
            }

            // Navigators
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (neighbors.first != null) {
                    PokemonNavigator(
                        position = "left",
                        image = neighbors.first!!.imagen,
                        name = neighbors.first!!.name,
                        number = neighbors.first!!.number,
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigateTo(neighbors.first!!.number) }
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.width(8.dp))

                if (neighbors.second != null) {
                    PokemonNavigator(
                        position = "right",
                        image = neighbors.second!!.imagen,
                        name = neighbors.second!!.name,
                        number = neighbors.second!!.number,
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigateTo(neighbors.second!!.number) }
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon, onNavigateToEvolution: (Int) -> Unit = {}) {
    val scrollState = rememberScrollState()

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(pokemon.imagen),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(y = 10.dp)
                .zIndex(2f)
                .size(150.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.height(150.dp))

                Chip(
                    pokemon.type.uppercase(),
                    ElectricYellow,
                    Modifier.padding(top = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Ability("row", label = "Altura", "${pokemon.height} m")
                        Ability("row", label = "Peso", "${pokemon.weight} kg")
                    }
                    VerticalDivider(
                        modifier = Modifier.height(60.dp),
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                    Ability("column", label = "Habilidad", pokemon.ability)
                }

                Text(
                    text = pokemon.description,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(top = 20.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )

                if (pokemon.evolutions.isNotEmpty()) {
                    Text(
                        text = "EVOLUCIONES",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(top = 24.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(top = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        pokemon.evolutions.forEach { evolution ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onNavigateToEvolution(evolution.number) },
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFF8F8F8)
                                ),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column {
                                        Text(
                                            text = evolution.name,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "#${evolution.number.toString().padStart(3, '0')}",
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                    }
                                    Image(
                                        painter = painterResource(evolution.imagen),
                                        contentDescription = evolution.name,
                                        modifier = Modifier.size(64.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                }
                            }
                        }
                    }
                }
                Box(modifier = Modifier.height(20.dp))
            }
        }
    }
}
