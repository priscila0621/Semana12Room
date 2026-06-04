package ni.edu.uam.inventarioacademico.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventarioacademico.data.local.entity.Prestamo

@Dao
interface PrestamoDao {

    @Query("SELECT * FROM prestamos")
    fun obtenerPrestamos(): Flow<List<Prestamo>>

    @Insert
    suspend fun insertarPrestamo(prestamo: Prestamo)

    @Update
    suspend fun actualizarPrestamo(prestamo: Prestamo)

    @Delete
    suspend fun eliminarPrestamo(prestamo: Prestamo)
}