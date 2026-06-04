package ni.edu.uam.inventarioacademico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.room.Room
import ni.edu.uam.inventarioacademico.data.local.InventarioDatabase
import ni.edu.uam.inventarioacademico.ui.screens.FormEquipoScreen
import ni.edu.uam.inventarioacademico.ui.theme.InventarioAcademicoTheme

class MainActivity : ComponentActivity() {

    private lateinit var db: InventarioDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            InventarioDatabase::class.java,
            "inventario_academico_db"
        ).build()

        enableEdgeToEdge()

        setContent {
            InventarioAcademicoTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {

                    FormEquipoScreen(
                        onGuardar = { nombre, categoria, marca, serie ->

                            println(
                                "Equipo: $nombre - $categoria - $marca - $serie"
                            )
                        }
                    )
                }
            }
        }
    }
}