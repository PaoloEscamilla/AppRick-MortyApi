package com.example.rickmortyapp_paolo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickmortyapp_paolo.navigation.AppNavigation
import com.example.rickmortyapp_paolo.ui.theme.RickMortyApp_PaoloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Mantén esta funcionalidad si la necesitas para tu diseño
        setContent {
            RickMortyApp_PaoloTheme {
                // Reemplazamos el Scaffold con la navegación de la aplicación
                AppNavigation()  // Aquí usamos la navegación entre pantallas
            }
        }
    }
}
