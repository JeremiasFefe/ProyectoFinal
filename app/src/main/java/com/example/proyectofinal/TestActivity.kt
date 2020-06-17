package com.example.proyectofinal

import android.graphics.Bitmap
import android.graphics.Color.*
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class TestActivity : AppCompatActivity(), View.OnTouchListener   {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        findViewById<ImageView>(R.id.image)?.setOnTouchListener(this)
    }

    override fun onTouch(v: View, ev: MotionEvent): Boolean {
        val evX = ev.x.toInt()
        val evY = ev.y.toInt()

        val touchColor: Int = getHotspotColor(R.id.maskImage, evX, evY)

        val ct = ColorTool()
        val tolerance = 25
        when {
            ct.closeMatch(RED, touchColor,tolerance*2) -> Log.i("test","RED")
            ct.closeMatch(BLUE, touchColor, tolerance*3) -> Log.i("test","BLUE")
            ct.closeMatch(YELLOW, touchColor, tolerance) ->Log.i("test","YELLOW")
            ct.closeMatch(WHITE, touchColor, tolerance) -> Log.i("test","WHITE")


        }
        return true
    }

    /**
     * Get the color from the hotspot image at point x-y.
     *
     */

    private fun getHotspotColor (hotspotId:Int, x:Int, y:Int): Int {
        return when (val img = findViewById<ImageView>(hotspotId)) {
            null -> {
                Log.d ("ImageAreasActivity", "Hot spot image not found")
                0
            }
            else -> {
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
    }
}

