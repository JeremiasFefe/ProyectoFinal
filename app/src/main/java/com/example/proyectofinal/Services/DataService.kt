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

    //Google Maps

    private val mapsBuscar = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F1.gif?alt=media&token=486f47aa-c628-478f-8abb-c1160573d63c","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_1_mask.jpg?alt=media&token=403a8fbb-1eab-4526-bb45-2f3cd1c9b346","Escribí acá a dónde querés ir"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F2.gif?alt=media&token=b3d89979-74de-49fb-a31a-5aa2ecb3940e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_barrabuscadora_1_mask.jpg?alt=media&token=7ab5ae7a-0a68-486e-85eb-7e0b3217ccfe","Seleccioná alguno de los resultados de tu búsqueda"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F3.gif?alt=media&token=b4d7a8a1-b338-40eb-85a9-f8e6bae4bb59","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_barrabuscadora_7_mask.jpg?alt=media&token=2fee94ac-daec-47f4-8a19-18c3cea5b132","Apretá en Indicaciones para conocer como ir"),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F4.gif?alt=media&token=ebafca0f-2178-4e11-ac96-53ecf16c5810","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2FMasks%2Fgooglemaps_iniciarruta_1_mask.jpg?alt=media&token=22e2899e-d2f1-486d-a869-f9c7ce11d48d","Apretá en iniciar para que comience el recorrido"),
            ExplanationStep("5","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FBuscar%20Algo%20%2F7.gif?alt=media&token=cc5a2252-d1a9-4b88-82cd-ce7d71ac5fb4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6","Prestá atención a las indicaciones")

    )

    private val mapsIniciar = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2F1.gif?alt=media&token=e2bf4680-0564-4425-b03d-8924397f71cf","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F1.jpg?alt=media&token=c95373dd-f7d2-45cb-a795-dc27588f9767","Escribí la dirección a la que deseás ir"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2F2.gif?alt=media&token=58c93610-8843-426e-b261-2e96319fae30","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F2.jpg?alt=media&token=40793eb1-81ad-46f6-aaa2-5b4a50ed9e94","Apretá en Indicaciones para conocer como ir"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2F3.gif?alt=media&token=bd23134c-73a0-4157-b4ff-60745da7007b","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F5.jpg?alt=media&token=fac41360-467d-4ad9-bae7-d3288cdfe96f","Elegí si vas a ir en auto, caminando, en transporte público o en bici"),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2F4.gif?alt=media&token=df143e48-ea89-4991-a408-416df9345640","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2FMasks%2F3.jpg?alt=media&token=a7eea28d-f4a1-4639-b6e9-e8a64c602a17","Apretá en iniciar para que comience el recorrido"),
            ExplanationStep("5","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Google%20Maps%2FIniciar%20una%20ruta%20o%20un%20recorrido%2F5.gif?alt=media&token=4e9f75a0-ddec-473d-9ab2-9468c62be27e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6","Prestá atención a las indicaciones")
    )

    //Whatsapp

    private val whatsappUsoGeneralExplanation = listOf(
            ExplanationStep("1","test_image","mask1", "este es el primer texto"),
            ExplanationStep("2","whatsapp2", "mask2", "segundo"),
            ExplanationStep("3","test_image", "mask1", "tercero"),
            ExplanationStep("4","whatsapp2", "mask2", "segundo")
    )

    //Youtube

    private val youtubeBuscarVideo = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F1.gif?alt=media&token=b152c35d-7501-4c2d-88b8-b7635a26659a","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F1.jpg?alt=media&token=6d867704-b855-49fa-bb9b-e0e5ff69da66","Apretá en la lupa para buscar"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F2.gif?alt=media&token=f9da9d00-ff08-411c-bedd-34649a3d3ddc","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F2.jpg?alt=media&token=b9741203-a57e-4d8f-b023-6eb317a01c8c","Escribí lo que quieras buscar"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F3.gif?alt=media&token=df42da07-a047-484d-8157-a666d0ac429e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F3.jpg?alt=media&token=aaf02233-be38-45d5-93f1-6fc6cb24d6f6","Elegí el resultado que quieras"),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F4.gif?alt=media&token=d7caf2a8-070f-448f-be79-eed482dc09c9","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F4.jpg?alt=media&token=dc8a94e5-2773-4c64-911a-07b11be84e5e","Arribá podes ver el video"),
            ExplanationStep("5","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F5.gif?alt=media&token=ab974f81-865b-4a51-b0c9-2ff457feb481","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F5.jpg?alt=media&token=c2b86a8f-de56-4a89-96b6-3ffe52e8828a","Podés ponerle me gusta o no me gusta"),
            ExplanationStep("6","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F6.gif?alt=media&token=afaf6404-d94e-4080-90f9-3d6879e46770","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FMasks%2F6.jpg?alt=media&token=44fc9dd8-c5a0-4713-8859-e73101f0ec66","Podés compartirlo con quien vos quieras"),
            ExplanationStep("7","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Youtube%2FBuscar%20un%20video%2FGifs%2F7.gif?alt=media&token=7de38bf6-2360-4d5a-a31c-e675ce49337e","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6","Si querés ver más videos similares podés suscribirte")
    )

    //Netflix

    private val netflixGeneral = listOf(
            ExplanationStep("1","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FGifs%2F1.jpeg?alt=media&token=bcd9be5b-8c8a-46f2-b345-d989d9db3219","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FMasks%2F1.jpg?alt=media&token=f0432cf2-b367-4536-9d88-7465a4fb4a92","Esta es la pantalla de inicio, si deslizás para abajo podés ver películas y series recomendadas"),
            ExplanationStep("2","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FGifs%2F2.gif?alt=media&token=8c7b53ce-ae35-4965-b728-6db5aa32c337","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FMasks%2F2.jpg?alt=media&token=9a846071-bbe9-440e-a9b2-87e26d9bd5c1","Para buscar una película o serie apretá en la lupa"),
            ExplanationStep("3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FGifs%2F3.gif?alt=media&token=8360aaca-cda1-4161-9b75-f535876b44a3","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FMasks%2F3.jpg?alt=media&token=6b591504-1740-4117-8319-f41238f03043","Escribí el nombre de lo que querés buscar"),
            ExplanationStep("4","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/Netflix%2FGifs%2F4.gif?alt=media&token=733d0ca4-cad2-44f4-9b58-91ad082dc7ae","https://firebasestorage.googleapis.com/v0/b/aprendapp-7fba8.appspot.com/o/mask%20blanca.png?alt=media&token=45b6180c-e31b-47e2-b16d-304d65a556c6","¡Seleccioná el resultado que deseás y a disfrutar!")
    )

    //General apps

    private val whatsappFunc = listOf(
            Functionality("Uso general", whatsappUsoGeneralExplanation),
            Functionality("Mandar mensaje",whatsappUsoGeneralExplanation),
            Functionality("Grabar audio",whatsappUsoGeneralExplanation),
            Functionality("Hacer llamada",whatsappUsoGeneralExplanation),
            Functionality("Descargar", blankStepsList)
    )


    private val youtubeFunc = listOf(
            Functionality("Buscar video", youtubeBuscarVideo),
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
            Functionality("Uso general", netflixGeneral),
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