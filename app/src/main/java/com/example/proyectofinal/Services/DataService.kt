package com.example.proyectofinal.Services

import com.example.proyectofinal.Model.App
import com.example.proyectofinal.Model.ExplanationStep
import com.example.proyectofinal.Model.Functionality

object DataService {
    val apps = listOf(
            App("WhatsApp","whatsapp","com.whatsapp"),
            App("YouTube","youtube","com.google.android.youtube"),
            App("Netflix","netflix","com.netflix.mediaclient"),
            App("Google Maps","maps","com.google.android.apps.maps")
            //App("Google Chrome","chrome")
    )
    private val blankStepsList= listOf(
            ExplanationStep("","","","")
    )
    private val mapsBarraBuscadora = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/giftest.gif?alt=media&token=bc119553-2b49-46d0-96a9-fc4c8feb3c7f","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/googlemaps_1_mask.jpg?alt=media&token=c398ebe0-c899-4cea-837f-72820d77b509",""),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/googlemaps_1.jpeg?alt=media&token=3b98aadc-277e-4cdd-aa83-658947c643a3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/googlemaps_1_mask.jpg?alt=media&token=c398ebe0-c899-4cea-837f-72820d77b509","")
    )

    private val whatsappUsoGeneralExplanation = listOf(
            ExplanationStep("1","test_image","mask1", "este es el primer texto"),
            ExplanationStep("2","whatsapp2", "mask2", "segundo"),
            ExplanationStep("3","test_image", "mask1", "tercero"),
            ExplanationStep("2","whatsapp2", "mask2", "segundo")
    )

    private val whatsappFunc = listOf(
            Functionality("Uso general", whatsappUsoGeneralExplanation),
            Functionality("Mandar mensaje",whatsappUsoGeneralExplanation),
            Functionality("Grabar audio",whatsappUsoGeneralExplanation),
            Functionality("Hacer llamada",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
    )


    private val youtubeFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Buscar video",whatsappUsoGeneralExplanation),
            Functionality("Explorar",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
    )


    private val mapsFunc = listOf(
            Functionality("Uso general", mapsBarraBuscadora),
            Functionality("Buscar dirección",whatsappUsoGeneralExplanation),
            Functionality("Buscar lugar",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
    )


    private val chromeFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Usar buscador",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
    )

    private val netflixFunc = listOf(
            Functionality("Uso general",whatsappUsoGeneralExplanation),
            Functionality("Buscar película",whatsappUsoGeneralExplanation),
            Functionality("Tv",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
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