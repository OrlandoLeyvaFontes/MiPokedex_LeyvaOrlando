package orlando.leyva.pokedexcompose_leyvafontesorlando.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orlando.leyva.pokedexcompose_leyvafontesorlando.components.PokemonGridItem
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.showAllPokemons
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.ElectricYellow
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.Red

@Composable
fun MenuScreen(
    username: String = "",
    onNavigateToDetail: (Int) -> Unit,
    onLogout: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ElectricYellow)
    ) {
        // Header con info del usuario
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "POKÉDEX",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black // Letras negras para mejor contraste
                )
                if (username.isNotEmpty()) {
                    Text(
                        text = "Entrenador: $username",
                        fontSize = 12.sp,
                        color = Color.Black.copy(alpha = 0.7f), // Negro con transparencia
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            if (username.isNotEmpty()) {
                Button(
                    onClick = { onLogout() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = "Cerrar Sesión",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Text(
            text = "Selecciona un Pokémon",
            fontSize = 14.sp,
            color = Color.Black.copy(alpha = 0.6f), // Negro con transparencia
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 12.dp)
        )

        // Grid de pokémons
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(Color.White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(showAllPokemons()) { pokemon ->
                PokemonGridItem(pokemon) { pokemonId ->
                    onNavigateToDetail(pokemonId)
                }
            }
        }
    }
}
