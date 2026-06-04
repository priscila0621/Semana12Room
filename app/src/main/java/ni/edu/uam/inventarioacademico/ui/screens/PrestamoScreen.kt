package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ni.edu.uam.inventarioacademico.data.local.entity.Prestamo

@Composable
fun PrestamoScreen(
    prestamos: List<Prestamo>
) {

    LazyColumn {

        items(prestamos) { prestamo ->

            Column {

                Text(
                    "Equipo: ${prestamo.equipoId}"
                )

                Text(
                    "Solicitante: ${prestamo.solicitante}"
                )

                Text(
                    "Préstamo: ${prestamo.fechaPrestamo}"
                )

                Text(
                    "Devolución: ${
                        prestamo.fechaDevolucion
                            ?: "Pendiente"
                    }"
                )
            }
        }
    }
}