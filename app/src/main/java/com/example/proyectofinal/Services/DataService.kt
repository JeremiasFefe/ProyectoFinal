package com.example.proyectofinal.Services

import com.example.proyectofinal.Model.App
import com.example.proyectofinal.Model.ExplanationStep
import com.example.proyectofinal.Model.Functionality

object DataService {
    val apps = listOf(
            App("WhatsApp","whatsapp"),
            App("YouTube","youtube"),
            App("Netflix","netflix"),
            App("Google Maps","maps")
            //App("Google Chrome","chrome")
    )

    private val whatsappUsoGeneralExplanation = listOf(
            ExplanationStep("1","test_image","test_mask", "este es el primer texto"),
            ExplanationStep("2","whatsapp2", "test_mask", "segundo"),
            ExplanationStep("3","test_image", "test_mask", "tercero"),
            ExplanationStep("2","whatsapp2", "test_mask", "segundo"),
            ExplanationStep("3","test_image", "test_mask", "tercero")
    )

    private val whatsappFunc = listOf(
            Functionality("Uso general", whatsappUsoGeneralExplanation),
            Functionality("Mandar mensaje",whatsappUsoGeneralExplanation),
            Functionality("Grabar audio",whatsappUsoGeneralExplanation),
            Functionality("Hacer llamada",whatsappUsoGeneralExplanation)
    )


    private val youtubeFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Buscar video",whatsappUsoGeneralExplanation),
            Functionality("Explorar",whatsappUsoGeneralExplanation)
    )


    private val mapsFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Buscar dirección",whatsappUsoGeneralExplanation),
            Functionality("Buscar lugar",whatsappUsoGeneralExplanation)
    )


    private val chromeFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Usar buscador",whatsappUsoGeneralExplanation)
    )

    private val netflixFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Buscar película",whatsappUsoGeneralExplanation),
            Functionality("Tv",whatsappUsoGeneralExplanation)
    )

    fun getFunctionalities(app: String): List<Functionality>{
        return when(app){
            "WhatsApp" -> whatsappFunc
            "YouTube" -> youtubeFunc
            "Google Maps"-> mapsFunc
            "Netflix" -> netflixFunc
            else -> chromeFunc
        }
    }
}