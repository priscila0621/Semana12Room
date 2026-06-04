package ni.edu.uam.inventarioacademico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ni.edu.uam.inventarioacademico.data.local.entity.Prestamo
import ni.edu.uam.inventarioacademico.data.repository.PrestamoRepository

class PrestamoViewModel(
    private val repository: PrestamoRepository
) : ViewModel() {

    val prestamos = repository.prestamos
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun registrarPrestamo(
        equipoId: Int,
        solicitante: String,
        fechaPrestamo: String
    ) {

        viewModelScope.launch {

            repository.insertar(
                Prestamo(
                    equipoId = equipoId,
                    solicitante = solicitante,
                    fechaPrestamo = fechaPrestamo
                )
            )
        }
    }
    fun registrarDevolucion(
        prestamo: Prestamo,
        fecha: String
    ) {

        viewModelScope.launch {

            repository.actualizar(
                prestamo.copy(
                    fechaDevolucion = fecha
                )
            )
        }
    }
}