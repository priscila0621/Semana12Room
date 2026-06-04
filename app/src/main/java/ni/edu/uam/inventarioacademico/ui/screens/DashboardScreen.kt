package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    totalEquipos: Int,
    disponibles: Int,
    prestados: Int,
    categoriaPrincipal: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "📦 Total equipos: $totalEquipos"
            )

            Text(
                text = "✅ Disponibles: $disponibles"
            )

            Text(
                text = "🔴 Prestados: $prestados"
            )

            Text(
                text = "🏆 Categoría principal: $categoriaPrincipal"
            )
        }
    }
}