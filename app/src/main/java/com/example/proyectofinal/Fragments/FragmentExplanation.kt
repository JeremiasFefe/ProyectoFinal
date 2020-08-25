package com.example.proyectofinal.Fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.proyectofinal.ColorTool
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_explanation.*
import javax.sql.DataSource
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


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        val animation: Animation = AnimationUtils.loadAnimation(context,R.anim.fadein)
        val args = FragmentExplanationArgs.fromBundle(requireArguments())
        val functionalitySelected = args.functionality
        val steps = functionalitySelected.explanationSteps

        stepImage = v.findViewById(R.id.imgStep)
        maskImage = v.findViewById(R.id.imgMask)

        Glide.with(this).load(steps[position].stepMask).centerCrop().into(maskImage)

        Glide.with(this).load(steps[position].stepImage).centerCrop().listener(object : RequestListener<Drawable> {
            override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                loadingCircle.visibility = View.GONE
                return false
            }
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                loadingCircle.visibility = View.GONE
                return false
            }
        }).into(stepImage)

        position+=1

        setHasOptionsMenu(true)

        stepImage.setOnTouchListener(fun(v: View, event: MotionEvent): Boolean {
            val action = event.action
            val evX = event.x.toInt()
            val evY = event.y.toInt()
            val touchColor: Int = getHotspotColor(R.id.imgMask, evX, evY)
            val ct = ColorTool()
            val tolerance = 25

            Log.d(TAG, "Pixel touched: $evX $evY")
            when(action){
                MotionEvent.ACTION_UP ->    {
                    when {
                        ct.closeMatch(Color.YELLOW, touchColor, tolerance) -> {
                            if(position<steps.size) {
                                v.startAnimation(animation)
                                loadingCircle.visibility = View.VISIBLE

                                //Glide.with(this).load(steps[position].stepImage).centerCrop().into(stepImage)
                                Glide.with(this).load(steps[position].stepMask).centerCrop().into(maskImage)

                                Glide.with(this).load(steps[position].stepImage).centerCrop().listener(object : RequestListener<Drawable> {
                                    override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                                        loadingCircle.visibility = View.GONE
                                        return false
                                    }
                                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                        loadingCircle.visibility = View.GONE
                                        return false
                                    }
                                }).into(stepImage)

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
        val bitmap = v.findViewById<ImageView>(hotspotId).drawable.toBitmap()
        val pixel = bitmap.getPixel(x,y)
        return pixel
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