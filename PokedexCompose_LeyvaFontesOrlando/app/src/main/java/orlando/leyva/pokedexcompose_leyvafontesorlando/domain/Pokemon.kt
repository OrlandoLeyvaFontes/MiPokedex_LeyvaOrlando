package orlando.leyva.pokedexcompose_leyvafontesorlando.domain

data class Pokemon(
    val name: String,
    val number: Int,
    val type: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val fav: Boolean,
    val ability: String,
    val imagen: Int,
    val evolutions: List<Pokemon> = emptyList()
)