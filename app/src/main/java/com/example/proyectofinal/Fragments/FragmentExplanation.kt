package com.example.proyectofinal.Fragments

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.proyectofinal.ColorTool
import com.example.proyectofinal.R


/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    private lateinit var v: View
    //private lateinit var adapter: ExplanationStepsAdapter
    //private lateinit var recyclerView: RecyclerView
    //private lateinit var txtFuncName: TextView
    private var position = 0
    private lateinit var stepImage: ImageView
    private lateinit var stepMaskImage: ImageView

    //private lateinit var steps:List<ExplanationStep>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        //recyclerView = v.findViewById(R.id.explanationRecyclerView)
        //recyclerView.setHasFixedSize(true)

       // txtFuncName = v.findViewById(R.id.txtFuncName)
        //steps = functionalitySelected.explanationSteps
        val inAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right_in)
        val outAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right_out)

       // txtFuncName.text = functionalitySelected.title

        //recyclerView.layoutManager = GridLayoutManager(activity,1)

        //adapter = context?.let { ExplanationStepsAdapter(it, steps) }!!

        //recyclerView.adapter = adapter

        //setHasOptionsMenu(true)

        val args = FragmentExplanationArgs.fromBundle(requireArguments())
        val functionalitySelected = args.functionality
        val steps = functionalitySelected.explanationSteps

        stepImage = v.findViewById(R.id.stepImage)
        stepMaskImage = v.findViewById(R.id.maskImage)
        var imageId = context?.resources?.getIdentifier(steps[position].stepImage,"drawable", requireContext().packageName)
        if (imageId != null) {
            stepImage.setImageResource(imageId)
        }
        var maskId = context?.resources?.getIdentifier(steps[0].stepMask,"drawable", requireContext().packageName)
        if (maskId != null) {
            stepMaskImage.setImageResource(maskId)
        }

        setHasOptionsMenu(true)

        v.setOnTouchListener(fun(v: View, event: MotionEvent): Boolean {
            val action = event.action;
            val evX = event.x.toInt()
            val evY = event.y.toInt()

            val touchColor: Int = getHotspotColor(R.id.maskImage, evX, evY)

            val ct = ColorTool()
            val tolerance = 25
            when(action){
                MotionEvent.ACTION_UP ->    {
                    when {
                        //ct.closeMatch(Color.RED, touchColor, tolerance * 2) -> Log.i("test", "RED")
                        //ct.closeMatch(Color.BLUE, touchColor, tolerance * 3) -> Log.i("test", "BLUE")
                        //ct.closeMatch(Color.WHITE, touchColor, tolerance) -> Log.i("test", "WHITE")
                        ct.closeMatch(Color.YELLOW, touchColor, tolerance) -> {

                            Log.i("test", steps[position].stepNumber)
                            if(position<steps.size-1) {
                                Toast.makeText(activity,"Pasando al siguiente paso",Toast.LENGTH_SHORT).show()
                                position+=1
                                imageId = context?.resources?.getIdentifier(steps[position].stepImage, "drawable", requireContext().packageName)
                                imageId?.let { stepImage.setImageResource(it) }

                                maskId = context?.resources?.getIdentifier(steps[position].stepMask, "drawable", requireContext().packageName)
                                maskId?.let { stepMaskImage.setImageResource(it) }
                            }else{
                                Toast.makeText(activity,"Sin más pasos",Toast.LENGTH_SHORT).show()
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