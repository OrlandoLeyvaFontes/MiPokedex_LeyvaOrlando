package orlando.leyva.pokedexcompose_leyvafontesorlando.utilities

import androidx.compose.ui.graphics.Color
import orlando.leyva.pokedexcompose_leyvafontesorlando.domain.Pokemon

fun getColorType(pokemon: Pokemon): Pair<Color, Color> {
    val type = pokemon.type.lowercase()
    return when {
        type.contains("fire") -> Pair(Color(0xFFFF9D3D), Color.White)
        type.contains("water") -> Pair(Color(0xFF5AADFF), Color.White)
        type.contains("grass") -> Pair(Color(0xFF78D34F), Color.White)
        type.contains("electric") -> Pair(Color(0xFFFFD93D), Color.Black)
        type.contains("ice") -> Pair(Color(0xFF78D8D8), Color.White)
        type.contains("fight") -> Pair(Color(0xFF9D3D3D), Color.White)
        type.contains("poison") -> Pair(Color(0xFF9D4DFF), Color.White)
        type.contains("ground") -> Pair(Color(0xFFD4A574), Color.White)
        type.contains("flying") -> Pair(Color(0xFFB8A7E8), Color.White)
        type.contains("psychic") -> Pair(Color(0xFFFF88D3), Color.White)
        type.contains("bug") -> Pair(Color(0xFFA8B820), Color.White)
        type.contains("rock") -> Pair(Color(0xFFB8A038), Color.White)
        type.contains("ghost") -> Pair(Color(0xFF705898), Color.White)
        type.contains("dragon") -> Pair(Color(0xFF7038F8), Color.White)
        type.contains("dark") -> Pair(Color(0xFF705848), Color.White)
        type.contains("steel") -> Pair(Color(0xFF9D9D9D), Color.White)
        type.contains("fairy") -> Pair(Color(0xFFEE99AC), Color.White)
        type.contains("normal") -> Pair(Color(0xFFA8A878), Color.White)
        else -> Pair(Color(0xFFD0D0D0), Color.Black)
    }
}
