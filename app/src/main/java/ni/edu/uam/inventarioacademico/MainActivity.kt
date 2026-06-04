package ni.edu.uam.inventarioacademico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.room.Room
import ni.edu.uam.inventarioacademico.data.local.InventarioDatabase
import ni.edu.uam.inventarioacademico.data.repository.EquipoRepository
import ni.edu.uam.inventarioacademico.data.repository.PrestamoRepository
import ni.edu.uam.inventarioacademico.ui.screens.FormPrestamoScreen
import ni.edu.uam.inventarioacademico.ui.screens.InventarioScreen
import ni.edu.uam.inventarioacademico.ui.screens.PrestamoScreen
import ni.edu.uam.inventarioacademico.ui.theme.InventarioAcademicoTheme
import ni.edu.uam.inventarioacademico.viewmodel.EquipoViewModel
import ni.edu.uam.inventarioacademico.viewmodel.PrestamoViewModel

class MainActivity : ComponentActivity() {

    private lateinit var db: InventarioDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            InventarioDatabase::class.java,
            "inventario_academico_db"
        ).build()

        val equipoRepository = EquipoRepository(
            db.equipoDao()
        )

        val prestamoRepository = PrestamoRepository(
            db.prestamoDao()
        )

        val equipoViewModel = EquipoViewModel(
            equipoRepository
        )

        val prestamoViewModel = PrestamoViewModel(
            prestamoRepository
        )

        enableEdgeToEdge()

        setContent {

            InventarioAcademicoTheme {

                val equipos by equipoViewModel.equipos.collectAsState()

                val prestamos by prestamoViewModel.prestamos.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->

                    Column {

                        InventarioScreen(
                            equipos = equipos,

                            onGuardarEquipo = {
                                    nombre,
                                    categoria,
                                    marca,
                                    serie ->

                                equipoViewModel.agregarEquipo(
                                    nombre,
                                    categoria,
                                    marca,
                                    serie
                                )
                            },

                            onEliminarEquipo = { equipo ->

                                equipoViewModel.eliminarEquipo(
                                    equipo
                                )
                            }
                        )

                        FormPrestamoScreen(
                            onRegistrar = {
                                    equipoId,
                                    solicitante,
                                    fecha ->

                                prestamoViewModel.registrarPrestamo(
                                    equipoId,
                                    solicitante,
                                    fecha
                                )
                            }
                        )

                        PrestamoScreen(
                            prestamos = prestamos
                        )
                    }
                }
            }
        }
    }
}