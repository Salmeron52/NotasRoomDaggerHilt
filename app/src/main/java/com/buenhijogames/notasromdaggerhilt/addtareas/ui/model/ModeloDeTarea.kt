package com.buenhijogames.notasromdaggerhilt.addtareas.ui.model

data class ModeloDeTarea(
    val id: Long = System.currentTimeMillis(),
    val tarea : String,
    var selected: Boolean = false
)