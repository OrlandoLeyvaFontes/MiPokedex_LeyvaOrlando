package orlando.leyva.pokedexcompose_leyvafontesorlando.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.Red
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.DarkGray

@Composable
fun Ability(type: String, label: String, value: String) {
    if (type == "row") {
        Row {
            Label(label)
            Spacer(modifier = Modifier.width(8.dp))
            Text(value, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    } else {
        Column {
            Label(label)
            Text(value, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = DarkGray)
        }
    }
}

@Composable
fun Label(text: String) {
    Text(text, color = Red, fontWeight = FontWeight.Bold, fontSize = 12.sp)
}