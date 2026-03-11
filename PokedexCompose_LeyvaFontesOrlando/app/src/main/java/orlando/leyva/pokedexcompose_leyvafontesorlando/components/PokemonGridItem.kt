package orlando.leyva.pokedexcompose_leyvafontesorlando.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.Pokemon
import orlando.leyva.pokedexcompose_leyvafontesorlando.utilities.getColorType

@Composable
fun PokemonGridItem(
    pokemon: Pokemon,
    onNavigationDetail: (id: Int) -> Unit = {}
) {
    val colors = getColorType(pokemon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onNavigationDetail(pokemon.number) }
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    color = colors.first.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Image(
                painter = painterResource(pokemon.imagen),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
            )

            Row(
                modifier = Modifier
                    .size(32.dp)
                    .background(colors.first, shape = RoundedCornerShape(50.dp))
                    .align(Alignment.TopEnd)
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "#${pokemon.number}",
                    color = colors.second,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = pokemon.name,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = pokemon.type.uppercase(),
            textAlign = TextAlign.Center,
            fontSize = 11.sp,
            color = colors.first,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
