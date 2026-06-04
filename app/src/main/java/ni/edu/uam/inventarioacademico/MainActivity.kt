package ni.edu.uam.inventarioacademico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.room.Room
import ni.edu.uam.inventarioacademico.data.local.InventarioDatabase
import ni.edu.uam.inventarioacademico.data.repository.EquipoRepository
import ni.edu.uam.inventarioacademico.ui.screens.InventarioScreen
import ni.edu.uam.inventarioacademico.ui.theme.InventarioAcademicoTheme
import ni.edu.uam.inventarioacademico.viewmodel.EquipoViewModel

class MainActivity : ComponentActivity() {

    private lateinit var db: InventarioDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            InventarioDatabase::class.java,
            "inventario_academico_db"
        ).build()

        val repository = EquipoRepository(
            db.equipoDao()
        )

        val viewModel = EquipoViewModel(
            repository
        )

        enableEdgeToEdge()

        setContent {

            InventarioAcademicoTheme {

                val equipos by viewModel.equipos.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->

                    InventarioScreen(
                        equipos = equipos,
                        onGuardarEquipo = {
                                nombre,
                                categoria,
                                marca,
                                serie ->

                            viewModel.agregarEquipo(
                                nombre,
                                categoria,
                                marca,
                                serie
                            )
                        }
                    )
                }
            }
        }
    }
}