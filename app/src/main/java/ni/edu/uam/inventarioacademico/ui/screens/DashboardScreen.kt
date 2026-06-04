package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DashboardScreen(
    totalEquipos: Int,
    disponibles: Int,
    prestados: Int,
    categoriaPrincipal: String
) {

    Column {

        Text(
            text = "Total equipos: $totalEquipos"
        )

        Text(
            text = "Disponibles: $disponibles"
        )

        Text(
            text = "Prestados: $prestados"
        )

        Text(
            text = "Categoría principal: $categoriaPrincipal"
        )
    }
}