package com.buenhijogames.notasromdaggerhilt.addtareas.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buenhijogames.notasromdaggerhilt.addtareas.ui.model.ModeloDeTarea
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TareasViewModel @Inject constructor() : ViewModel() {

    private val _mostrarDialogo = MutableLiveData<Boolean>()
    val mostrarDialogo: LiveData<Boolean> = _mostrarDialogo

    private val _tareas = mutableStateListOf<ModeloDeTarea>()
    val tareas: List<ModeloDeTarea> = _tareas

    fun onDismissDialogo() {
        _mostrarDialogo.value = false
    }

    fun onTareaAdded(unaTarea: String) {
        _mostrarDialogo.value = false
        _tareas.add(ModeloDeTarea(tarea = unaTarea))
        /*Log.d("TareasViewModel", "Tarea creada: $unaTarea")*/
    }

    fun onMostrarDialogo() {
        _mostrarDialogo.value = true
    }

    fun onCheckedChange(modeloDeTarea: ModeloDeTarea) {
        val indice = _tareas.indexOf(modeloDeTarea)
        _tareas[indice] = _tareas[indice].let {
            it.copy(selected = !it.selected)
        }
    }

    fun onTareaChanged(modeloDeTarea: ModeloDeTarea) {
        val indice = _tareas.indexOf(modeloDeTarea)
        _tareas[indice] = _tareas[indice].let {
            it.copy(tarea = it.tarea)
        }

    }

    fun onTareaDeleted(modeloDeTarea: ModeloDeTarea) {
        val tarea = _tareas.find { it.id == modeloDeTarea.id }
        _tareas.remove(tarea)

    }
}