package com.example.proyectofinal.Services

import com.example.proyectofinal.Model.App
import com.example.proyectofinal.Model.Functionality

object DataService {
    val apps = listOf(
            App("Whatsapp","whatsapp"),
            App("YouTube","youtube"),
            App("Google Maps","maps"),
            App("Google Chrome","chrome")
    )

    val whatsappFunc = listOf(
            Functionality("Uso general"),
            Functionality("Mandar mensaje"),
            Functionality("Grabar audio"),
            Functionality("Hacer llamada")
    )


    val youtubeFunc = listOf(
            Functionality("Uso general"),
            Functionality("Buscar video"),
            Functionality("Grabar audio"),
            Functionality("Hacer llamada")
    )


    val mapsFunc = listOf(
            Functionality("Uso general"),
            Functionality("Buscar dirección"),
            Functionality("Grabar audio"),
            Functionality("Hacer llamada")
    )


    val chromeFunc = listOf(
            Functionality("Uso general"),
            Functionality("Usar buscador"),
            Functionality("Grabar audio"),
            Functionality("Hacer llamada")
    )
}