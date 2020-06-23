package com.example.proyectofinal.Fragments

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.proyectofinal.ColorTool
import com.example.proyectofinal.R
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    private lateinit var v: View
    private var position = 0
    private lateinit var stepImage: ImageView
    private lateinit var maskImage: ImageView
    private var imageId by Delegates.notNull<Int>()
    private var maskId by Delegates.notNull<Int>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        val animation: Animation = AnimationUtils.loadAnimation(context,R.anim.fadein)
        val args = FragmentExplanationArgs.fromBundle(requireArguments())
        val functionalitySelected = args.functionality
        val steps = functionalitySelected.explanationSteps

        stepImage = v.findViewById(R.id.stepImage)
        maskImage = v.findViewById(R.id.maskImage)

        imageId = context?.resources?.getIdentifier(steps[position].stepImage,"drawable", requireContext().packageName)!!
        stepImage.setImageResource(imageId)

        
        maskId = context?.resources?.getIdentifier(steps[position].stepMask,"drawable", requireContext().packageName)!!
        maskImage.setImageResource(maskId)

        position+=1

        setHasOptionsMenu(true)

        v.setOnTouchListener(fun(v: View, event: MotionEvent): Boolean {
            val action = event.action
            val evX = event.x.toInt()
            val evY = event.y.toInt()
            val touchColor: Int = getHotspotColor(R.id.maskImage, evX, evY)
            val ct = ColorTool()
            val tolerance = 25
            when(action){
                MotionEvent.ACTION_UP ->    {
                    when {
                        ct.closeMatch(Color.YELLOW, touchColor, tolerance) -> {
                            if(position<steps.size) {
                                v.startAnimation(animation)
                                imageId = context?.resources?.getIdentifier(steps[position].stepImage,"drawable",requireContext().packageName)!!
                                stepImage.setImageResource(imageId)

                                maskId = context?.resources?.getIdentifier(steps[position].stepMask, "drawable",requireContext().packageName)!!
                                maskImage.setImageResource(maskId)

                                position+=1
                            }
                        }

                    }
                }
            }

            return true
         })

        return v

    }

    private fun getHotspotColor (hotspotId:Int, x:Int, y:Int): Int {
        return when (val img = v.findViewById<ImageView>(hotspotId)) {
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)

    }
}