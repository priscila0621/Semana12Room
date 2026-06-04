package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun FormPrestamoScreen(
    onRegistrar: (
        Int,
        String,
        String
    ) -> Unit
) {

    var equipoId by remember { mutableStateOf("") }
    var solicitante by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    OutlinedTextField(
        value = equipoId,
        onValueChange = { equipoId = it },
        label = { Text("ID Equipo") }
    )

    OutlinedTextField(
        value = solicitante,
        onValueChange = { solicitante = it },
        label = { Text("Solicitante") }
    )

    OutlinedTextField(
        value = fecha,
        onValueChange = { fecha = it },
        label = { Text("Fecha") }
    )

    Button(
        onClick = {

            if (equipoId.isNotEmpty()) {

                onRegistrar(
                    equipoId.toInt(),
                    solicitante,
                    fecha
                )
            }
        }
    ) {
        Text("Registrar Préstamo")
    }
}