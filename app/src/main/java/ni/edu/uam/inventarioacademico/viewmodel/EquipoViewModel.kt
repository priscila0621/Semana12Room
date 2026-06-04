package ni.edu.uam.inventarioacademico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ni.edu.uam.inventarioacademico.data.local.entity.Equipo
import ni.edu.uam.inventarioacademico.data.repository.EquipoRepository

class EquipoViewModel(
    private val repository: EquipoRepository
) : ViewModel() {

    val equipos = repository.equipos
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun agregarEquipo(
        nombre: String,
        categoria: String,
        marca: String,
        serie: String
    ) {

        viewModelScope.launch {

            repository.insertar(
                Equipo(
                    nombre = nombre,
                    categoria = categoria,
                    marca = marca,
                    numeroSerie = serie
                )
            )
        }
    }
    fun eliminarEquipo(equipo: Equipo) {

        viewModelScope.launch {
            repository.eliminar(equipo)
        }
    }
}