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
    private val mapsBuscar = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F1.gif?alt=media&token=486f47aa-c628-478f-8abb-c1160573d63c","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_1_mask.jpg?alt=media&token=403a8fbb-1eab-4526-bb45-2f3cd1c9b346","1"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F2.gif?alt=media&token=b3d89979-74de-49fb-a31a-5aa2ecb3940e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_barrabuscadora_1_mask.jpg?alt=media&token=7ab5ae7a-0a68-486e-85eb-7e0b3217ccfe","2"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F3.gif?alt=media&token=b4d7a8a1-b338-40eb-85a9-f8e6bae4bb59","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_barrabuscadora_7_mask.jpg?alt=media&token=2fee94ac-daec-47f4-8a19-18c3cea5b132",""),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F4.gif?alt=media&token=ebafca0f-2178-4e11-ac96-53ecf16c5810","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_iniciarruta_1_mask.jpg?alt=media&token=22e2899e-d2f1-486d-a869-f9c7ce11d48d",""),
            ExplanationStep("5","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F5.gif?alt=media&token=993aa322-7f6a-4e29-bd63-557a2f401cd9","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_iniciarruta_2_mask.jpg?alt=media&token=87e46c4a-c63a-4522-af57-675cd17b1165",""),
            ExplanationStep("6","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F6.gif?alt=media&token=6cd2615f-f940-4997-99e6-a6808c0ae54e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_iniciarruta_2_mask.jpg?alt=media&token=87e46c4a-c63a-4522-af57-675cd17b1165",""),
            ExplanationStep("7","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F7.gif?alt=media&token=cc5a2252-d1a9-4b88-82cd-ce7d71ac5fb4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6","")

    )

    private val mapsIniciar = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2Fgooglemaps_1%20(1)_2.gif?alt=media&token=4e66df88-9c71-4b4a-8edc-3e0c82cd4113","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F1.jpg?alt=media&token=c95373dd-f7d2-45cb-a795-dc27588f9767","Prueba de texto 1"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2Fgooglemaps_1%20(1)_6.gif?alt=media&token=cec97497-ed9c-4e90-813b-333f324966ad","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F2.jpg?alt=media&token=40793eb1-81ad-46f6-aaa2-5b4a50ed9e94","Prueba de texto 2"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2Fgooglemaps_1%20(1)_7.gif?alt=media&token=f00026d8-e898-451a-b848-1b55666b66a5","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F3.jpg?alt=media&token=a7eea28d-f4a1-4639-b6e9-e8a64c602a17","Prueba de texto 3"),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2Fgooglemaps_1%20(1)_10.gif?alt=media&token=3b93d435-bbee-4842-81ad-ed1122aec572","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6",""),
            ExplanationStep("","","",""),
            ExplanationStep("","","","")
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
            Functionality("Buscar", mapsBuscar),
            Functionality("Iniciar recorrido", mapsIniciar),
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