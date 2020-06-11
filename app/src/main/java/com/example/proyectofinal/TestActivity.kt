package com.example.proyectofinal

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class TestActivity : AppCompatActivity(), View.OnTouchListener   {
    private lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        findViewById<ImageView>(R.id.image)?.setOnTouchListener(this)
        toast ("Touch the screen to discover where the regions are.")
    }

    /**
     * Respond to the user touching the screen.
     * Change images to make things appear and disappear from the screen.
     *
     */

    override fun onTouch(v: View, ev: MotionEvent): Boolean {
       // Log.i("test","OnTouchCalled")
        var handledHere: Boolean
        val action = ev.action
        val evX = ev.x.toInt()
        val evY = ev.y.toInt()
        var nextImage = -1 // resource id of the next image to display

        // If we cannot find the imageView, return.
        val imageView = v.findViewById<View>(R.id.image) as ImageView

        // When the action is Down, see if we should show the "pressed" image for the default image.
        // We do this when the default image is showing. That condition is detectable by looking at the
        // tag of the view. If it is null or contains the resource number of the default image, display the pressed image.
        val tagNum: Int? = imageView.tag as? Int
        when (action) {
            MotionEvent.ACTION_DOWN -> if (tagNum == R.drawable.p2_ship_default) {
                nextImage = R.drawable.p2_ship_pressed
                handledHere = true
                /*
       } else if (currentResource != R.drawable.p2_ship_default) {
         nextImage = R.drawable.p2_ship_default;
         handledHere = true;
       */
            } else handledHere = true
            MotionEvent.ACTION_UP -> {
                // On the UP, we do the click action.
                // The hidden image (image_areas) has three different hotspots on it.
                // The colors are red, blue, and yellow.
                // Use image_areas to determine which region the user touched.
                val touchColor: Int = getHotspotColor(R.id.image_areas, evX, evY)

                // Compare the touchColor to the expected values. Switch to a different image, depending on what color was touched.
                // Note that we use a Color Tool object to test whether the observed color is close enough to the real color to
                // count as a match. We do this because colors on the screen do not match the map exactly because of scaling and
                // varying pixel density.
                val ct = ColorTool()
                val tolerance = 25
                nextImage = R.drawable.p2_ship_default
                when {
                    ct.closeMatch(Color.RED, touchColor, tolerance) -> Log.i("test","Apretada imagen 1") //nextImage = R.drawable.p2_ship_alien
                    ct.closeMatch(Color.BLUE, touchColor, tolerance) -> Log.i("test","Apretada imagen 2") //nextImage = R.drawable.p2_ship_powered
                    ct.closeMatch(Color.YELLOW, touchColor, tolerance) -> Log.i("test","Apretada imagen 3") //nextImage = R.drawable.p2_ship_no_star
                    ct.closeMatch(Color.WHITE, touchColor, tolerance) -> Log.i("test","Apretada imagen 4") //nextImage = R.drawable.p2_ship_default


                    // If the next image is the same as the last image, go back to the default.
                }

                // If the next image is the same as the last image, go back to the default.
                //toast ("Current image:  next: $nextImage")
                if (tagNum == nextImage) {
                    nextImage = R.drawable.p2_ship_default
                }
                handledHere = true
            }
            else -> handledHere = false
        }
        if (handledHere) {
           // toast("Image clicked")
            if (nextImage > 0) {
                imageView.setImageResource(nextImage)
                imageView.tag = nextImage
            }
        }
        return handledHere
    }


    /**
     * Handle a click on the Wglxy views at the bottom.
     *
     */

    public fun onClickWglxy (v:View) {
        val viewIntent = Intent ("android.intent.action.VIEW",
                Uri.parse("http://double-star.appspot.com/blahti/ds-download.html"))
        startActivity(viewIntent)

    }


    /**
     */
// More methods

    /**
     * Get the color from the hotspot image at point x-y.
     *
     */

    private fun getHotspotColor (hotspotId:Int, x:Int, y:Int): Int {
        val img = findViewById<ImageView>(hotspotId)
        return if (img == null) {
            Log.d ("ImageAreasActivity", "Hot spot image not found")
            0
        } else {
            img.isDrawingCacheEnabled = true
            val hotspots = Bitmap.createBitmap(img.drawingCache)
            if (hotspots == null) {
                Log.d ("ImageAreasActivity", "Hot spot bitmap was not created")
                0
            } else {
                img.isDrawingCacheEnabled = false
                hotspots.getPixel(x, y)
            }
        }
    }

    /**
     * Show a string on the screen via Toast.
     *
     * @param msg String
     * @return void
     */

    private fun toast (msg:String)
    {
        Toast.makeText (applicationContext, msg, Toast.LENGTH_SHORT).show ()
    } // end toast

} // end class

