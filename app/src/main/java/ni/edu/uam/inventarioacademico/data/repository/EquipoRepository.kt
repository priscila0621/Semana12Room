package ni.edu.uam.inventarioacademico.data.repository

import ni.edu.uam.inventarioacademico.data.local.dao.EquipoDao
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo

class EquipoRepository(
    private val dao: EquipoDao
) {

    val equipos = dao.obtenerEquipos()

    suspend fun insertar(equipo: Equipo) {
        dao.insertarEquipo(equipo)
    }

    suspend fun actualizar(equipo: Equipo) {
        dao.actualizarEquipo(equipo)
    }

    suspend fun eliminar(equipo: Equipo) {
        dao.eliminarEquipo(equipo)
    }
}