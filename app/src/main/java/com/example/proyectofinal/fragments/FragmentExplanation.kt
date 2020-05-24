package com.example.proyectofinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R

/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    lateinit var v: View
    lateinit var TxtExplanation: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)
        TxtExplanation = v.findViewById(R.id.txt_explanation)
        TxtExplanation.text = "Explanation Fragment"
        return v
    }
}