package orlando.leyva.pokedexcompose_leyvafontesorlando

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.Ability
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.Chip
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.PokemonNavigator
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.Pokemon
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.ElectricYellow
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.PokedexCompose_LeyvaFontesOrlandoTheme
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.White


class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(
        name = "Pikachu",
        number = 25,
        type = "Eléctrico",
        description = "Pokémon de tipo eléctrico que genera electricidad en sus mejillas. Es experto en crear campos eléctricos y en descargar bolts de energía. Tiene una naturaleza alegre y competitiva.",
        height = 0.4f,
        weight = 6f,
        fav = true,
        ability = "Estática",
        imagen = R.drawable.pikachu
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexCompose_LeyvaFontesOrlandoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(pokemon, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = name, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "#${number.toString().padStart(3, '0')}", fontSize = 16.sp, color = Color.White)
        }
        Box {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "pokeball image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(130.dp).offset(30.dp, 20.dp)
            )
            Image(
                painter = painterResource(if (fav) R.drawable.star_filled else R.drawable.star_outline),
                contentDescription = if (fav) "yellow star filled" else "yellow star outlined",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun PokemonCard(name: String, weight: Float, height: Float, description: String, ability: String, type: String, image: Int) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            modifier = Modifier.offset(0.dp, -80.dp).zIndex(2f).size(160.dp),
            contentScale = ContentScale.Fit
        )
        Card(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Chip(type, ElectricYellow, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))

                Row(
                    modifier = Modifier.fillMaxWidth(0.85f).padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Ability("row", label = "Altura", "${height} m")
                        Ability("row", label = "Peso", "${weight} kg")
                    }
                    Divider(modifier = Modifier.height(50.dp).width(1.dp), color = Color.LightGray)
                    Ability("column", label = "Habilidad", ability)
                }

                Text(
                    text = description,
                    modifier = Modifier.fillMaxWidth(0.85f).padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(ElectricYellow, RectangleShape).fillMaxSize()) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)

        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 16.dp).padding(top = 80.dp)
        ) {
            PokemonCard(pokemon.name, pokemon.weight, pokemon.height, pokemon.description, pokemon.ability, pokemon.type, pokemon.imagen)
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonNavigator(position = "left", image = R.drawable.arbok, name = "Arbok", number = 24, modifier = Modifier.weight(1f))
            PokemonNavigator(position = "right", image = R.drawable.raichu, name = "Raichu", number = 26, modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview() {
    PokedexCompose_LeyvaFontesOrlandoTheme {
        PokemonHeader("Pikachu", 25, true)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexCompose_LeyvaFontesOrlandoTheme {
        Greeting(Pokemon(name = "Pikachu", number = 25, type = "Eléctrico", description = "Pokémon de tipo eléctrico que genera electricidad en sus mejillas.", height = 0.4f, weight = 6f, fav = true, ability = "Estática", imagen = R.drawable.pikachu))
    }
}