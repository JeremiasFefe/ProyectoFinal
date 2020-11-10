package com.example.proyectofinal.Fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.proyectofinal.ColorTool
import com.example.proyectofinal.Model.Functionality
import com.example.proyectofinal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kcrimi.tooltipdialog.ToolTipDialog
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
    private lateinit var functionalitySelected:Functionality
    private lateinit var helpButton: FloatingActionButton

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.fadein)
        val args = FragmentExplanationArgs.fromBundle(requireArguments())
        functionalitySelected = args.functionality
        val steps = functionalitySelected.explanationSteps

        stepImage = v.findViewById(R.id.imgStep)
        maskImage = v.findViewById(R.id.imgMask)
        helpButton = v.findViewById(R.id.helpButton)
        helpButton.hide()
        Glide.with(this).load(steps[position].stepMask).centerCrop().into(maskImage)

        Glide.with(this).load(steps[position].stepImage).centerCrop().listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                loadingCircle.visibility = View.GONE
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                loadingCircle.visibility = View.GONE
                if (resource is GifDrawable) {
                    resource.setLoopCount(1)
                }
                helpButton.show()
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

            helpButton.hide()

            Log.d(TAG, "Pixel touched: $evX $evY")
            when (action) {
                MotionEvent.ACTION_UP -> {
                    when {
                        ct.closeMatch(Color.YELLOW, touchColor, tolerance) -> {
                            if (position < steps.size) {
                                v.startAnimation(animation)
                                loadingCircle.visibility = View.VISIBLE

                                //Glide.with(this).load(steps[position].stepImage).centerCrop().into(stepImage)
                                Glide.with(this).load(steps[position].stepMask).centerCrop().into(maskImage)

                                Glide.with(this).load(steps[position].stepImage).centerCrop().listener(object : RequestListener<Drawable> {
                                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                        loadingCircle.visibility = View.GONE
                                        return false
                                    }

                                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                                        loadingCircle.visibility = View.GONE
                                        if (resource is GifDrawable) {
                                            resource.setLoopCount(1)
                                        }
                                        helpButton.show()
                                        return false
                                    }
                                }).into(stepImage)

                                position += 1
                            }
                        }

                    }
                }
            }
            return true
        })
        helpButton.setOnClickListener {
            if (position <= steps.size) {
                context?.let { it1 ->
                    ToolTipDialog(it1,requireActivity()).title(steps[position - 1].stepDescription)
                            //.content(steps[position].stepDescription) // Body content
                            .setYPosition(760)
                            .show()
                }

            }
        }

        return v
    }

    private fun getHotspotColor(hotspotId: Int, x: Int, y: Int): Int {
        val bitmap = v.findViewById<ImageView>(hotspotId).drawable.toBitmap()
        val pixel = bitmap.getPixel(x, y)
        return pixel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_explanation, menu)
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            val spanString = SpannableString(menu.getItem(i).title.toString())
            val end = spanString.length
            spanString.setSpan(RelativeSizeSpan(1.3f), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            item.title = spanString
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val steps = functionalitySelected.explanationSteps
        return when (item.itemId) {
            R.id.fragmentInfo -> {
                context?.let {
                    if (position <= steps.size) {
                        ToolTipDialog(it, requireActivity())
                                .title(steps[position - 1].stepDescription)
                                //.content(steps[position].stepDescription) // Body content
                                .pointTo(1000, 350)
                                .show()
                    }
                }
                true

            }
            else ->
                super.onOptionsItemSelected(item)
        }




         // Build and show the tooltip


    }
}