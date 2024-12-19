package com.buenhijogames.notasromdaggerhilt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.buenhijogames.notasromdaggerhilt.addtareas.ui.TareasScreen
import com.buenhijogames.notasromdaggerhilt.addtareas.ui.TareasViewModel

@Composable
fun NavManager(modifier: Modifier = Modifier, tareasViewModel: TareasViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Tareas) {
        composable<Tareas> {
            TareasScreen(tareasViewModel = tareasViewModel)
        }
    }
}