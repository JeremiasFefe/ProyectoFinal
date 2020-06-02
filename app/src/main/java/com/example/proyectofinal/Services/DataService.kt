package com.example.proyectofinal.Services

import com.example.proyectofinal.Model.App
import com.example.proyectofinal.Model.Functionality

object DataService {
    val apps = listOf(
            App("Whatsapp","whatsapp"),
            App("YouTube","youtube"),
            App("Netflix","netflix"),
            App("Google Maps","maps")
            //App("Google Chrome","chrome")
    )

    private val whatsappFunc = listOf(
            Functionality("Uso general"),
            Functionality("Mandar mensaje"),
            Functionality("Grabar audio"),
            Functionality("Hacer llamada")
    )


    private val youtubeFunc = listOf(
            Functionality("Uso general"),
            Functionality("Buscar video"),
            Functionality("Explorar")
    )


    private val mapsFunc = listOf(
            Functionality("Uso general"),
            Functionality("Buscar dirección"),
            Functionality("Buscar lugar")
    )


    private val chromeFunc = listOf(
            Functionality("Uso general"),
            Functionality("Usar buscador")
    )

    private val netflixFunc = listOf(
            Functionality("Uso general"),
            Functionality("Buscar película"),
            Functionality("Tv")
    )

    fun getFunctionalities(app: String): List<Functionality>{
        return when(app){
            "Whatsapp" -> whatsappFunc
            "YouTube" -> youtubeFunc
            "Google Maps"-> mapsFunc
            "Netflix" -> netflixFunc
            else -> chromeFunc
        }
    }
}