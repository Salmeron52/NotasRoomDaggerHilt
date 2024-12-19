package com.buenhijogames.notasromdaggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.buenhijogames.notasromdaggerhilt.addtareas.ui.TareasViewModel
import com.buenhijogames.notasromdaggerhilt.navigation.NavManager
import com.buenhijogames.notasromdaggerhilt.ui.theme.NotasRomDaggerHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val tareasViewModel: TareasViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotasRomDaggerHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(
                        modifier = Modifier.padding(innerPadding),
                        tareasViewModel = tareasViewModel
                    )
                }
            }
        }
    }
}