package com.example.aplicaciondepreguntas.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicaciondepreguntas.Pregunta
import com.example.aplicaciondepreguntas.R

@Composable
fun PantallaPregunta() {
    var pregunta by remember {
        mutableStateOf(0)
    }
    var respuesta by remember{
        mutableStateOf(true)
    }
    val listaPreguntas = CreaPregunta()
    var mensaje by remember {
        mutableStateOf("")
    }
    var color by remember{
        mutableStateOf(Color.White)
    }
    var color2 by remember {
        mutableStateOf(Color.DarkGray)
    }
    var color3 by remember {
        mutableStateOf(Color.DarkGray)
    }
Column{
Text(listaPreguntas[pregunta].texto, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
Image(listaPreguntas[pregunta].imagen, contentDescription = "")
    Text(mensaje, color= color)
Row {
    Button(onClick = { respuesta = true ; if (respuesta == listaPreguntas[pregunta].resultado){
        mensaje = "¡Correcto!"
        color = Color.Green
        color2 = Color.Green
        color3 = Color.Red
    }
    else {
        mensaje = "Incorrecto."
        color = Color.Red
        color2 = Color.Red
        color3 = Color.Green}}, colors = ButtonDefaults.buttonColors(color2))
    {Text("Verdadero")
    }
    Button(onClick = { respuesta = false ; if (respuesta == listaPreguntas[pregunta].resultado){
        mensaje = "¡Correcto!"
        color = Color.Green
        color3 = Color.Green
        color2 = Color.Red
    }
    else {
        mensaje = "Incorrecto."
        color = Color.Red
        color3 = Color.Red
        color2 = Color.Green}} , colors = ButtonDefaults.buttonColors(color3))
    {
        Text("Falso")
    }
}
    Row {
        Button(onClick = { if (pregunta == 0){
            mensaje = ""
            color2 = Color.DarkGray
            color3 = Color.DarkGray
            pregunta = 4
        }
        else {
            mensaje = ""
            color2 = Color.DarkGray
            color3 = Color.DarkGray
            pregunta--
        }}) {
            Row{
                Icon(Icons.Default.ArrowBack, contentDescription = null)
                Text("Anterior")
            }
        }
        Button(onClick = { if (pregunta == 4){
            mensaje = ""
            color2 = Color.DarkGray
            color3 = Color.DarkGray
            pregunta = 0
        }
        else {
            mensaje = ""
            color2 = Color.DarkGray
            color3 = Color.DarkGray
            pregunta++
        }}) {
            Row{
                Text("Siguiente")
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            }
        }
    }
}
}

@Preview
@Composable
fun PantallaPreguntaPreview(){
PantallaPregunta()
}

@Composable
fun CreaPregunta(): List<Pregunta>{
    var listaPreguntas = mutableListOf<Pregunta>()
    val pregunta1 = Pregunta("La CherryBomb Milk se desbloquea en el primer día de la celebración", painterResource(id = R.drawable._5_cherrybomb_milk), true)
    val pregunta2 = Pregunta("El pavo siempre ha sido de celebración", painterResource(id = R.drawable.__turkish), false)
    val pregunta3 = Pregunta("Los pecans son tanto un mix como un topping", painterResource(id = R.drawable.__pecan_mix_phd), false)
    val pregunta4 = Pregunta("El té de mocha es uno de los iniciales", painterResource(id = R.drawable.__mocha_tea_2), true)
    val pregunta5 = Pregunta("El Rainbow Whip es una de las cremas nuevas del Freezeria", painterResource(id = R.drawable._2_rainbow_whip), false)
    listaPreguntas.add(pregunta1)
    listaPreguntas.add(pregunta2)
    listaPreguntas.add(pregunta3)
    listaPreguntas.add(pregunta4)
    listaPreguntas.add(pregunta5)
    return listaPreguntas
}