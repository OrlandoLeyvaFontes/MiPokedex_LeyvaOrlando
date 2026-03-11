package orlando.leyva.pokedexcompose_leyvafontesorlando.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
fun RegisterScreen(
    onRegisterSuccess: (String) -> Unit,
    onBackToLogin: () -> Unit,
    registeredUsers: List<String>
) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ElectricYellow)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 20.dp),
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
                    text = "Crea tu Cuenta",
                    fontSize = 18.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        // Register Form
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(24.dp)
                .padding(bottom = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Registrarse",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Nombre del Entrenador") },
                    placeholder = { Text("Tu nombre") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Correo Electrónico") },
                    placeholder = { Text("ejemplo@correo.com") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Contraseña") },
                    placeholder = { Text("Mínimo 4 caracteres") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                OutlinedTextField(
                    value = confirmPassword.value,
                    onValueChange = { confirmPassword.value = it },
                    label = { Text("Confirmar Contraseña") },
                    placeholder = { Text("Repite tu contraseña") },
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
                            .padding(vertical = 4.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {
                        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
                        when {
                            name.value.isBlank() -> {
                                errorMessage.value = "Por favor ingresa tu nombre"
                            }
                            email.value.isBlank() -> {
                                errorMessage.value = "Por favor ingresa tu correo"
                            }
                            !email.value.matches(emailPattern.toRegex()) -> {
                                errorMessage.value = "Ingresa un correo válido"
                            }
                            password.value.isBlank() -> {
                                errorMessage.value = "Por favor ingresa una contraseña"
                            }
                            password.value.length < 4 -> {
                                errorMessage.value = "La contraseña debe tener al menos 4 caracteres"
                            }
                            password.value != confirmPassword.value -> {
                                errorMessage.value = "Las contraseñas no coinciden"
                            }
                            else -> {
                                // Registro exitoso
                                onRegisterSuccess(name.value)
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ElectricYellow,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Registrarse",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Text(
                    text = "¿Ya tienes cuenta? Volver",
                    fontSize = 13.sp,
                    color = DarkGray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clickable { onBackToLogin() }
                )
            }
        }
        Box(modifier = Modifier.padding(bottom = 40.dp))
    }
}
