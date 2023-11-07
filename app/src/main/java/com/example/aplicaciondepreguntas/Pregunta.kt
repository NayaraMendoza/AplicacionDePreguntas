package com.example.aplicaciondepreguntas

import androidx.compose.ui.graphics.painter.Painter

data class Pregunta(val texto: String, val imagen: Painter, val resultado: Boolean)