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
    ) -> Unit,
    onEliminarEquipo: (Equipo) -> Unit,
    onEditarEquipo: (Equipo) -> Unit
) {

    val categoriaPrincipal = equipos
        .groupBy { it.categoria }
        .maxByOrNull { it.value.size }
        ?.key ?: "N/A"

    Column {

        DashboardScreen(
            totalEquipos = equipos.size,
            disponibles = equipos.count { it.disponible },
            prestados = equipos.count { !it.disponible },
            categoriaPrincipal = categoriaPrincipal
        )

        FormEquipoScreen(
            onGuardar = onGuardarEquipo
        )

        ListaEquiposScreen(
            equipos = equipos,
            onEliminar = onEliminarEquipo,
            onEditar = onEditarEquipo
        )
    }
}