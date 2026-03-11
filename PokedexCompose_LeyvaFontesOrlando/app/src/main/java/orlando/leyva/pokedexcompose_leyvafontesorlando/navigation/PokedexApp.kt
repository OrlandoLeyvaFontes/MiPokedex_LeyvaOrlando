package orlando.leyva.pokedexcompose_leyvafontesorlando.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import orlando.leyva.pokedexcompose_leyvafontesorlando.screen.DetailScreen
import orlando.leyva.pokedexcompose_leyvafontesorlando.screen.LoginScreen
import orlando.leyva.pokedexcompose_leyvafontesorlando.screen.MenuScreen
import orlando.leyva.pokedexcompose_leyvafontesorlando.screen.RegisterScreen

sealed class Screen {
    object Login : Screen()
    object Register : Screen()
    object Menu : Screen()
    data class Detail(val pokemonId: Int) : Screen()
}

@Composable
fun PokedexApp() {
    val currentScreen = remember { mutableStateOf<Screen>(Screen.Login) }
    val isAuthenticated = remember { mutableStateOf(false) }
    val username = remember { mutableStateOf("") }
    
    // Almacenamiento de usuarios registrados
    val registeredUsers = remember { mutableStateOf(listOf("trainer")) }

    when (val screen = currentScreen.value) {
        is Screen.Login -> {
            LoginScreen(
                onLoginSuccess = { user ->
                    username.value = user
                    isAuthenticated.value = true
                    currentScreen.value = Screen.Menu
                },
                onNavigateToRegister = {
                    currentScreen.value = Screen.Register
                },
                registeredUsers = registeredUsers.value
            )
        }

        is Screen.Register -> {
            RegisterScreen(
                onRegisterSuccess = { user ->
                    // Agregar nuevo usuario a la lista
                    registeredUsers.value = registeredUsers.value + user
                    username.value = user
                    isAuthenticated.value = true
                    currentScreen.value = Screen.Menu
                },
                onBackToLogin = {
                    currentScreen.value = Screen.Login
                },
                registeredUsers = registeredUsers.value
            )
        }

        is Screen.Menu -> {
            MenuScreen(
                username = username.value,
                onNavigateToDetail = { pokemonId ->
                    currentScreen.value = Screen.Detail(pokemonId)
                },
                onLogout = {
                    isAuthenticated.value = false
                    username.value = ""
                    currentScreen.value = Screen.Login
                }
            )
        }

        is Screen.Detail -> {
            DetailScreen(
                pokemonId = screen.pokemonId,
                onNavigateBack = {
                    currentScreen.value = Screen.Menu
                },
                onNavigateTo = { pokemonId ->
                    currentScreen.value = Screen.Detail(pokemonId)
                }
            )
        }
    }
}
