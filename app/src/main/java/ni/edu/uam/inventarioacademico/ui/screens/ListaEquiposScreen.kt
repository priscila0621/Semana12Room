package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo

@Composable
fun ListaEquiposScreen(
    equipos: List<Equipo>
) {

    LazyColumn {

        items(equipos) { equipo ->

            Text(
                text = "${equipo.nombre} - ${equipo.marca}"
            )
        }
    }
}