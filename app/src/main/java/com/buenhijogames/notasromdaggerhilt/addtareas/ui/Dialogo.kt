package com.buenhijogames.notasromdaggerhilt.addtareas.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.buenhijogames.notasromdaggerhilt.addtareas.ui.model.ModeloDeTarea
import com.buenhijogames.notasromdaggerhilt.componentes.MiBoton
import com.buenhijogames.notasromdaggerhilt.componentes.MiOutlinedTextField
import com.buenhijogames.notasromdaggerhilt.componentes.Titulo
import com.buenhijogames.notasromdaggerhilt.ui.theme.GrisOscuro
import com.buenhijogames.notasromdaggerhilt.ui.theme.Pink80

@Composable
fun DialogoTareas(
    mostrarDialogo: Boolean,
    onDismiss: () -> Unit,
    onTareaAdded: (String) -> Unit = {}
) {

    var tarea by remember { mutableStateOf("") }

    if (mostrarDialogo) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(GrisOscuro),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Titulo("Añadir Tarea")
                Spacer(modifier = Modifier.size(8.dp))
                MiOutlinedTextField(
                    texto = tarea,
                    onValueChange = { tarea = it },
                    label = "Tarea",
                    horizontalPadding = 4,
                    verticalPadding = 0,
                )
                Spacer(modifier = Modifier.size(8.dp))
                MiBoton(texto = "Añadir") { onTareaAdded(tarea); tarea = ""}
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }

}

@Composable
fun ItemTarea(modeloDeTarea: ModeloDeTarea, tareasViewModel: TareasViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = { tareasViewModel.onTareaDeleted(modeloDeTarea) }
                )
            },
        colors = CardDefaults.cardColors(Color.Red, Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = modeloDeTarea.tarea,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
                fontSize = 16.sp
            )
            Checkbox(
                checked = modeloDeTarea.selected,
                onCheckedChange = { tareasViewModel.onCheckedChange(modeloDeTarea) })
        }
    }

}

@Composable
fun ListaDeTareas(tareasViewModel: TareasViewModel) {

    val misTareas: List<ModeloDeTarea> = tareasViewModel.tareas

    LazyColumn {
        items(
            misTareas,
            key = { it.id }
        ) { tarea ->
            ItemTarea(modeloDeTarea = tarea, tareasViewModel = tareasViewModel)
        }
    }
}
