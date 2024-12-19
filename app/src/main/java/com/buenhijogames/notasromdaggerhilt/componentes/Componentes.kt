package com.buenhijogames.notasromdaggerhilt.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun Titulo(
    titulo: String,
    color: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = titulo,
        color = color,
        fontWeight = fontWeight
    )
}

@Composable
fun MiOutlinedTextField(
    texto: String,
    onValueChange: (String) -> Unit,
    label: String,
    horizontalPadding: Int = 32,
    verticalPadding: Int = 8,
    bottomPadding: Int = 16
) {
    OutlinedTextField(
        value = texto,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .padding(
                horizontal = horizontalPadding.dp,
                vertical = verticalPadding.dp
            )
            .padding(bottom = bottomPadding.dp),
        maxLines = 1,
        singleLine = true
    )
}


val Principal = Color(0xFFF11748)

@Composable
fun MiFloatingActionButton(color: Color = Principal, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Principal,
        contentColor = Color.White,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
        )
    }
}

@Composable
fun MiBoton(texto: String, colorTexto: Color = Color.White, onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
    ) {
        Text(texto, color = colorTexto)
    }
}

@Composable
fun MiIconButton(
    icon: ImageVector,
    color: Color = Color.White,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            tint = color
        )
    }
}