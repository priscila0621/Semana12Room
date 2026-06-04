package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo

@Composable
fun ListaEquiposScreen(
    equipos: List<Equipo>,
    onEliminar: (Equipo) -> Unit
) {

    LazyColumn {

        items(equipos) { equipo ->

            Card(
                modifier = Modifier.padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("Nombre: ${equipo.nombre}")
                    Text("Categoría: ${equipo.categoria}")
                    Text("Marca: ${equipo.marca}")
                    Text("Serie: ${equipo.numeroSerie}")

                    Button(
                        onClick = {
                            onEliminar(equipo)
                        }
                    ) {
                        Text("Eliminar")
                    }
                }
            }
        }
    }
}