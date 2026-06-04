package ni.edu.uam.inventarioacademico.data.repository

import ni.edu.uam.inventarioacademico.data.local.dao.PrestamoDao
import ni.edu.uam.inventarioacademico.data.local.entity.Prestamo

class PrestamoRepository(
    private val prestamoDao: PrestamoDao
) {

    val prestamos = prestamoDao.obtenerPrestamos()

    suspend fun insertar(prestamo: Prestamo) {
        prestamoDao.insertarPrestamo(prestamo)
    }

    suspend fun actualizar(prestamo: Prestamo) {
        prestamoDao.actualizarPrestamo(prestamo)
    }

    suspend fun eliminar(prestamo: Prestamo) {
        prestamoDao.eliminarPrestamo(prestamo)
    }
}