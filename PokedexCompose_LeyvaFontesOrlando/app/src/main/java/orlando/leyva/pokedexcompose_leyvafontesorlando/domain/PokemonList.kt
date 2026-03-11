package orlando.leyva.pokedexcompose_leyvafontesorlando.domain

import orlando.leyva.pokedexcompose_leyvafontesorlando.R

val pokemonList = listOf(
    Pokemon(
        name = "Bulbasaur",
        number = 1,
        type = "grass/poison",
        description = "Un Pokémon que lleva una semilla en el lomo desde que nace.",
        height = 0.7f,
        weight = 6.9f,
        fav = true,
        ability = "Espesura",
        imagen = R.drawable.bulbasaur,
        evolutions = listOf(
            Pokemon(
                "Ivysaur",
                2,
                "grass/poison",
                "Cuando el bulbo de su espalda crece, parece no poder ponerse de pie sobre sus patas traseras.",
                1.0f,
                13.0f,
                false,
                "Espesura",
                R.drawable.ivysaur
            ),
            Pokemon(
                "Venusaur",
                3,
                "grass/poison",
                "La planta florece cuando absorbe energía solar. Ésta le obliga a ponerse en busca de la luz solar.",
                2.0f,
                100f,
                false,
                "Espesura",
                R.drawable.venusaur
            )
        )
    ),

    Pokemon(
        name = "Charmander",
        number = 4,
        type = "fire",
        description = "La llama de su cola indica su estado emocional.",
        height = 0.6f,
        weight = 8.5f,
        fav = false,
        ability = "Mar Llamas",
        imagen = R.drawable.charmander,
        evolutions = listOf(
            Pokemon("Charmeleon", 5, "fire", "Cuando está luchando su llama arde vivamente, esto eleva las temperaturas.", 1.1f, 19.0f, false, "Mar Llamas", R.drawable.charmeleon),
            Pokemon("Charizard",  6, "fire/flying", "Escupe fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.", 1.7f, 90.5f, false, "Mar Llamas", R.drawable.charizard)
        )
    ),

    Pokemon(
        name = "Squirtle",
        number = 7,
        type = "water",
        description = "Se protege dentro de su caparazón y ataca con agua.",
        height = 0.5f,
        weight = 9.0f,
        fav = false,
        ability = "Torrente",
        imagen = R.drawable.squirtle,
        evolutions = listOf(
            Pokemon("Wartortle", 8,  "water", "Se oculta en el agua para cazar a sus presas. Al nadar rápidamente, mueve sus orejas para nivelarse.", 1.0f, 22.5f, false, "Torrente", R.drawable.wartortle),
            Pokemon("Blastoise", 9,  "water", "Un brutal Pokémon con reactores de agua en su caparazón. Éstos son usados para rápidos placajes.", 1.6f, 85.5f, false, "Torrente", R.drawable.blastoise)
        )
    ),

    Pokemon(
        name = "Pikachu",
        number = 25,
        type = "electric",
        description = "Cuando varios de estos Pokémon se juntan, su energía puede causar tormentas eléctricas.",
        height = 0.4f,
        weight = 6.0f,
        fav = true,
        ability = "Electricidad estática",
        imagen = R.drawable.pikachu,
        evolutions = listOf(
            Pokemon(
                "Raichu",
                26,
                "electric",
                "Su cola descarga electricidad al suelo, protegiéndose de ataques.",
                0.8f,
                30.0f,
                false,
                "Electricidad estática",
                R.drawable.raichu
            )
        )
    ),

    Pokemon(
        name = "Jigglypuff",
        number = 39,
        type = "normal/fairy",
        description = "Canta para dormir a sus oponentes.",
        height = 0.5f,
        weight = 5.5f,
        fav = false,
        ability = "Gran Encanto",
        imagen = R.drawable.jigglypuff,
        evolutions = listOf(
            Pokemon("Wigglytuff", 40, "normal/fairy", "Su cuerpo es blando y gomoso. Cuando se enfada traga aire y se hincha enormemente.", 1.0f, 12.0f, false, "Gran Encanto", R.drawable.wigglytuff)
        )
    ),

    Pokemon(
        name = "Meowth",
        number = 52,
        type = "normal",
        description = "Ama los objetos brillantes y las monedas.",
        height = 0.4f,
        weight = 4.2f,
        fav = false,
        ability = "Recogida",
        imagen = R.drawable.meowth,
        evolutions = listOf(
            Pokemon("Persian", 53, "normal", "Aunque es muy admirado por su pelo, es difícil de entrenar como mascota por su voluble maldad.", 1.0f, 32.0f, false, "Recogida", R.drawable.persian)
        )
    ),

    Pokemon(
        name = "Psyduck",
        number = 54,
        type = "water",
        description = "Sufre constantes dolores de cabeza que liberan poderes psíquicos.",
        height = 0.8f,
        weight = 19.6f,
        fav = false,
        ability = "Humedad",
        imagen = R.drawable.psyduck,
        evolutions = listOf(
            Pokemon("Golduck", 55, "water", "Suele ser visto nadando elegante por los lagos. Es confundido con el monstruo japonés, Kappa.", 1.7f, 76.6f, false, "Humedad", R.drawable.golduck)
        )
    ),

    Pokemon(
        name = "Machop",
        number = 66,
        type = "fight",
        description = "Entrena constantemente para fortalecer su cuerpo.",
        height = 0.8f,
        weight = 19.5f,
        fav = false,
        ability = "Agallas",
        imagen = R.drawable.machop,
        evolutions = listOf(
            Pokemon("Machoke",  67, "fight", "Su musculoso cuerpo es tan fuerte que usa un cinto anti-fuerza para controlar sus movimientos.", 1.5f, 70.5f, false, "Agallas", R.drawable.machoke),
            Pokemon("Machamp", 68, "fight", "Con sus fuertes músculos, lanza bestiales puñetazos y envía a su víctima al lejano horizonte.", 1.6f, 130f,  false, "Agallas", R.drawable.machamp)
        )
    ),

    Pokemon(
        name = "Geodude",
        number = 74,
        type = "rock/ground",
        description = "Se encuentra comúnmente en montañas y caminos.",
        height = 0.4f,
        weight = 20.0f,
        fav = false,
        ability = "Cabeza Roca",
        imagen = R.drawable.geodude,
        evolutions = listOf(
            Pokemon("Graveler",  75, "rock/ground", "Se mueve rodando cuesta abajo. Rueda sobre todo obstáculo sin frenar o cambiar de dirección.", 1.0f, 105f,  false, "Cabeza Roca", R.drawable.graveler),
            Pokemon("Golem",    76, "rock/ground", "Su cuerpo rocoso es super duro. Soporta las explosiones de dinamita sin sufrir daño.", 1.4f, 300f,  false, "Cabeza Roca", R.drawable.golem)
        )
    ),

    Pokemon(
        name = "Gengar",
        number = 94,
        type = "ghost/poison",
        description = "Se oculta en las sombras y absorbe el calor de sus víctimas.",
        height = 1.5f,
        weight = 40.5f,
        fav = true,
        ability = "Levitación",
        imagen = R.drawable.gengar,
        evolutions = listOf(
            Pokemon("Gastly",  92, "ghost/poison", "Casi invisible, este gaseoso Pokémon cubre al enemigo y lo adormece sin previo aviso.", 1.3f, 0.1f,  false, "Levitación", R.drawable.gastly),
            Pokemon("Haunter", 93, "ghost/poison", "Por su habilidad para atravesar muros de piedra, se dice que viene de otra dimensión", 1.6f, 0.1f,  false, "Levitación", R.drawable.haunter)
        )
    ),

    Pokemon(
        name = "Eevee",
        number = 133,
        type = "normal",
        description = "Tiene un ADN inestable que le permite evolucionar de muchas formas.",
        height = 0.3f,
        weight = 6.5f,
        fav = true,
        ability = "Fuga",
        imagen = R.drawable.eevee,
        evolutions = listOf(
            Pokemon("Vaporeon",  134, "water",    "Vive cerca del agua. Su larga cola termina en una aleta muy parecida a la de una sirena", 1.0f, 29.0f, false, "Absorbe Agua", R.drawable.vaporeon),
            Pokemon("Jolteon",   135, "electric", "Acumula iones negativos en la atmósfera para lanzar rayos de 10000 voltios de potencia.", 0.8f, 24.5f, false, "Pararrayos",  R.drawable.jolteon),
            Pokemon("Flareon",   136, "fire",     "Cuando almacena energía térmica en su cuerpo, su temperatura puede subir a más de 1600 grados.", 0.9f, 25.0f, false, "Mar Llamas",  R.drawable.flareon)
        )
    ),

    Pokemon(
        name = "Arbok",
        number = 24,
        type = "poison",
        description = "Una cobra con capazón letal detrás de su cabeza.",
        height = 3.5f,
        weight = 65.0f,
        fav = false,
        ability = "Desprendimiento",
        imagen = R.drawable.arbok
    )
)

fun showAllPokemons(): List<Pokemon> {
    return pokemonList.sortedBy { it.number }
}

val allPokemon: List<Pokemon> by lazy {
    pokemonList + pokemonList.flatMap { it.evolutions }
}

fun returnOnePokemon(): Pokemon {
    return pokemonList.get((0..9).random())
}

fun getPokemon(id: Int): Pokemon? = allPokemon.firstOrNull { it.number == id }

fun getNeighbors(id: Int): Pair<Pokemon?, Pokemon?> {
    val sortedList = pokemonList.sortedBy { it.number }
    val index = sortedList.indexOfFirst { it.number == id }

    if (index == -1) return Pair(null, null)

    val prev = if (index > 0) sortedList[index - 1] else null
    val next = if (index < sortedList.lastIndex) sortedList[index + 1] else null

    return Pair(prev, next)
}
