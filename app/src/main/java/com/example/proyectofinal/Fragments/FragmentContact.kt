package com.example.proyectofinal.Fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import com.google.android.gms.common.wrappers.Wrappers.packageManager
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class FragmentContact : Fragment() {
    private lateinit var v: View
    private lateinit var igSocial: ImageView
    private lateinit var fbSocial: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_contact, container, false)
        igSocial = v.findViewById(R.id.imgIg)
        fbSocial = v.findViewById(R.id.imgFb)

        igSocial.setImageResource(R.drawable.ic_logoig)
        fbSocial.setImageResource(R.drawable.ic_logofb)

        return v

    }

    override fun onStart() {
        super.onStart()
        igSocial.setOnClickListener {
            openInstagramUser("jere_fefe")
        }
        fbSocial.setOnClickListener {
            openFacebookPage("ortargentina")
        }
    }

    private fun openWhatsAppContact(number: String) {
        try {
            if (isAppInstalled("com.whatsapp")) {
                val whatsappUrl =
                        String.format("https://api.whatsapp.com/send?phone=%s&text%s", number, "")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl))
                //intent.setPackage("com.whatsapp")
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } else {
                Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT).show()
                val uri = Uri.parse("market://details?id=com.whatsapp")
                val goToMarket = Intent(Intent.ACTION_VIEW, uri)
                startActivity(goToMarket)
            }
        } catch (e: Exception) {
            Snackbar.make(v, "intent error", Snackbar.LENGTH_SHORT).show()
            Log.w(TAG, "IntentException: $e")
        }
    }

    private fun openFacebookPage(page: String) {
        try {
            if (isAppInstalled("com.facebook.katana")) {
                val facebookUri =
                        Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/$page")
                val intent = Intent(Intent.ACTION_VIEW, facebookUri)
                startActivity(intent)
            } else {
                val facebookUri = Uri.parse("https://www.facebook.com/$page")
                val intent = Intent(Intent.ACTION_VIEW, facebookUri)
                startActivity(intent)
            }
        } catch (e: Exception) {
            Snackbar.make(v, "intent error", Snackbar.LENGTH_SHORT).show()
            Log.w(TAG, "IntentException: $e")
        }
    }

    private fun openTwitterUser(user: String) {
        /*
        if(isAppInstalled("com.twitter.android")) {
            val twitterUri = Uri.parse("twitter://user?user_id=$user")
            val intent = Intent(Intent.ACTION_VIEW, twitterUri)
            intent.setPackage("com.twitter.android")
            startActivity(intent)
        } else {
            val twitterUri = Uri.parse("https://twitter.com/$user")
            val intent = Intent(Intent.ACTION_VIEW, twitterUri)
            startActivity(intent)
        }
         */
        try {
            val twitterUri = Uri.parse("https://twitter.com/$user")
            val intent = Intent(Intent.ACTION_VIEW, twitterUri)
            startActivity(intent)
        } catch (e: Exception) {
            Snackbar.make(v, "intent error", Snackbar.LENGTH_SHORT).show()
            Log.w(TAG, "IntentException: $e")
        }
    }

    private fun openInstagramUser(user: String) {
        try {
            val instagramUri = Uri.parse("http://instagram.com/_u/$user")
            val intent = Intent(Intent.ACTION_VIEW, instagramUri)
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        } catch (e: Exception) {
            val instagramUri = Uri.parse("http://instagram.com/$user")
            val intent = Intent(Intent.ACTION_VIEW, instagramUri)
            startActivity(intent)
        }
    }

    private fun openYoutubeVideo(vid: String) {
        try {
            if (isAppInstalled("com.google.android.youtube")) {
                val videoUri = Uri.parse("vnd.youtube:$vid")
                val intent = Intent(Intent.ACTION_VIEW, videoUri)
                intent.setPackage("com.google.android.youtube")
                startActivity(intent)
            } else {
                val videoUri = Uri.parse("http://www.youtube.com/watch?v=$vid")
                val intent = Intent(Intent.ACTION_VIEW, videoUri)
                startActivity(intent)
            }
        } catch (e: Exception) {
            Snackbar.make(v, "intent error", Snackbar.LENGTH_SHORT).show()
            Log.w(TAG, "IntentException: $e")
        }
    }

    private fun openYoutubeChannel(channel: String) {
        try {
            val channelUri = Uri.parse("http://www.youtube.com/channel/$channel")
            val intent = Intent(Intent.ACTION_VIEW, channelUri)
            startActivity(intent)
        } catch (e: Exception) {
            Snackbar.make(v, "intent error", Snackbar.LENGTH_SHORT).show()
            Log.w(TAG, "IntentException: $e")
        }
    }

    private fun isAppInstalled(uri: String): Boolean {
        val pm = packageManager(context)
        var appInstalled = false
        appInstalled = try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return appInstalled
    }
}