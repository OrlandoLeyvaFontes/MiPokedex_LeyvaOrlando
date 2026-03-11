package orlando.leyva.pokedexcompose_leyvafontesorlando.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.DarkGray

@Composable
fun PokemonNavigator(
    position: String,
    image: Int,
    name: String,
    number: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        if (position == "left") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Anterior",
                    modifier = Modifier.size(24.dp),
                    tint = DarkGray
                )
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = name,
                    modifier = Modifier.size(55.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = name,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkGray
                    )
                    Text(
                        text = "N.° ${number.toString().padStart(3, '0')}",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterEnd),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = name,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkGray
                    )
                    Text(
                        text = "N.° ${number.toString().padStart(3, '0')}",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = name,
                    modifier = Modifier.size(55.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Siguiente",
                    modifier = Modifier.size(24.dp),
                    tint = DarkGray
                )
            }
        }
    }
}
