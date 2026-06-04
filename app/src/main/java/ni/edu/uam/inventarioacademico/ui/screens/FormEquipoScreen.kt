package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable

@Composable
fun FormEquipoScreen(
    onGuardar: (
        String,
        String,
        String,
        String
    ) -> Unit
) {

    var nombre by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )

    OutlinedTextField(
        value = categoria,
        onValueChange = { categoria = it },
        label = { Text("Categoría") }
    )

    OutlinedTextField(
        value = marca,
        onValueChange = { marca = it },
        label = { Text("Marca") }
    )

    OutlinedTextField(
        value = serie,
        onValueChange = { serie = it },
        label = { Text("Serie") }
    )

    Button(
        onClick = {
            onGuardar(
                nombre,
                categoria,
                marca,
                serie
            )
        }
    ) {
        Text("Guardar")
    }
}