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
import ni.edu.uam.inventarioacademico.data.local.entity.Prestamo

@Composable
fun PrestamoScreen(
    prestamos: List<Prestamo>,
    onDevolver: (Prestamo) -> Unit
) {

    LazyColumn {

        items(prestamos) { prestamo ->

            Card(
                modifier = Modifier.padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Equipo: ${prestamo.equipoId}"
                    )

                    Text(
                        text = "Solicitante: ${prestamo.solicitante}"
                    )

                    Text(
                        text = "Préstamo: ${prestamo.fechaPrestamo}"
                    )

                    Text(
                        text = "Devolución: ${
                            prestamo.fechaDevolucion
                                ?: "Pendiente"
                        }"
                    )

                    if (prestamo.fechaDevolucion == null) {

                        Button(
                            onClick = {
                                onDevolver(prestamo)
                            }
                        ) {
                            Text("Registrar devolución")
                        }
                    }
                }
            }
        }
    }
}