package orlando.leyva.pokedexcompose_leyvafontesorlando.components

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonNavigator(
    position: String,
    image: Int,
    name: String,
    number: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = if (position == "left") Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (position == "left") {
            Image(
                painter = painterResource(android.R.drawable.ic_media_previous),
                contentDescription = "Previous Pokemon",
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(image),
                contentDescription = name,
                modifier = Modifier
                    .size(55.dp)
                    .padding(horizontal = 6.dp),
                contentScale = ContentScale.Fit
            )
            Column {
                Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                Text(
                    text = "N.° ${String.format("%04d", number)}",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        } else {
            Column(horizontalAlignment = Alignment.End) {
                Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                Text(
                    text = "N.° ${String.format("%04d", number)}",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
            Image(
                painter = painterResource(image),
                contentDescription = name,
                modifier = Modifier
                    .size(55.dp)
                    .padding(horizontal = 6.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(android.R.drawable.ic_media_next),
                contentDescription = "Next Pokemon",
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}