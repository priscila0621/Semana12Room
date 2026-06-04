package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DashboardScreen(
    totalEquipos: Int,
    disponibles: Int,
    prestados: Int
) {

    Text(
        text = """
            Total equipos: $totalEquipos
            Disponibles: $disponibles
            Prestados: $prestados
        """.trimIndent()
    )
}