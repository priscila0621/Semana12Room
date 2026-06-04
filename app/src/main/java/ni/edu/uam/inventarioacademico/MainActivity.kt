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
import ni.edu.uam.inventarioacademico.ui.screens.ListaEquiposScreen
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

        val equipoRepository = EquipoRepository(
            db.equipoDao()
        )

        val equipoViewModel = EquipoViewModel(
            equipoRepository
        )

        enableEdgeToEdge()

        setContent {
            InventarioAcademicoTheme {

                val equipos by equipoViewModel.equipos.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->

                    ListaEquiposScreen(
                        equipos = equipos
                    )
                }
            }
        }
    }
}