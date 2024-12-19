package com.buenhijogames.notasromdaggerhilt.addtareas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buenhijogames.notasromdaggerhilt.componentes.MiFloatingActionButton
import com.buenhijogames.notasromdaggerhilt.componentes.Principal
import com.buenhijogames.notasromdaggerhilt.componentes.Titulo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TareasScreen(
    tareasViewModel: TareasViewModel,
    modifier: Modifier = Modifier
) {
    val mostrarDialogo: Boolean by tareasViewModel.mostrarDialogo.observeAsState(false)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Titulo("Tareas") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Principal
                )
            )
        },
        floatingActionButton = {
            MiFloatingActionButton { tareasViewModel.onMostrarDialogo() }
        }
    ) {innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(4.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ListaDeTareas(tareasViewModel)
            DialogoTareas(
                mostrarDialogo = mostrarDialogo,
                onDismiss = { tareasViewModel.onDismissDialogo() },
                onTareaAdded = { tareasViewModel.onTareaAdded(it) }
            )
        }
    }


}