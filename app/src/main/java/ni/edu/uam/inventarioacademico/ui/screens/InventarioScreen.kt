package ni.edu.uam.inventarioacademico.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo

@Composable
fun InventarioScreen(
    equipos: List<Equipo>,
    onGuardarEquipo: (
        String,
        String,
        String,
        String
    ) -> Unit
) {

    Column {

        FormEquipoScreen(
            onGuardar = onGuardarEquipo
        )

        ListaEquiposScreen(
            equipos = equipos
        )
    }
}