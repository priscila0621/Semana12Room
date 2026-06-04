package ni.edu.uam.inventarioacademico.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo

@Dao
interface EquipoDao {

    @Query("SELECT * FROM equipos")
    fun obtenerEquipos(): Flow<List<Equipo>>

    @Insert
    suspend fun insertarEquipo(equipo: Equipo)

    @Update
    suspend fun actualizarEquipo(equipo: Equipo)

    @Delete
    suspend fun eliminarEquipo(equipo: Equipo)

    @Query("SELECT * FROM equipos WHERE id = :id")
    suspend fun obtenerEquipoPorId(id: Int): Equipo?
}