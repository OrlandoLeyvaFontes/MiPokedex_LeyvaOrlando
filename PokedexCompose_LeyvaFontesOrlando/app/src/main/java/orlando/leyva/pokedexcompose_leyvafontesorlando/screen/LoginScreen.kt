package orlando.leyva.pokedexcompose_leyvafontesorlando.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.ElectricYellow
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.DarkGray
import orlando.leyva.pokedexcompose_leyvafontesorlando.ui.theme.Red

@Composable
fun LoginScreen(
    onLoginSuccess: (String) -> Unit,
    onNavigateToRegister: () -> Unit,
    registeredUsers: List<String>
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ElectricYellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "POKÉDEX",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "¡Bienvenido Entrenador!",
                    fontSize = 18.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }

        // Login Form
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .weight(1.5f)
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Inicia Sesión",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Correo Electrónico") },
                    placeholder = { Text("Ingresa tu correo") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Contraseña") },
                    placeholder = { Text("Ingresa tu contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                // Error message
                if (errorMessage.value.isNotEmpty()) {
                    Text(
                        text = errorMessage.value,
                        color = Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {
                        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
                        when {
                            email.value.isBlank() -> {
                                errorMessage.value = "Por favor ingresa tu correo"
                            }
                            !email.value.matches(emailPattern.toRegex()) -> {
                                errorMessage.value = "Ingresa un correo válido"
                            }
                            password.value.isBlank() -> {
                                errorMessage.value = "Por favor ingresa tu contraseña"
                            }
                            // Nota: En un sistema real buscaríamos por email, aquí mantenemos la lista de usuarios por simplicidad
                            !registeredUsers.contains(email.value) && email.value != "trainer@pokedex.com" -> {
                                errorMessage.value = "Correo no registrado"
                            }
                            else -> {
                                errorMessage.value = ""
                                onLoginSuccess(email.value.split("@")[0])
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ElectricYellow,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(12.dp)
                    )
                }

                Text(
                    text = "¿No tienes cuenta? Registrarse",
                    fontSize = 13.sp,
                    color = ElectricYellow,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clickable { onNavigateToRegister() }
                )
            }
        }

        Box(modifier = Modifier.weight(0.5f))
    }
}
