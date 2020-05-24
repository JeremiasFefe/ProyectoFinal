package com.example.proyectofinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.proyectofinal.R

/**
 * A simple [Fragment] subclass.
 */
class FragmentFunctionalities : Fragment() {
    lateinit var v: View
    lateinit var btnFuncToExpl: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_functionalities, container, false)
        btnFuncToExpl = v.findViewById(R.id.btn_func_to_expl)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnFuncToExpl.setOnClickListener { v ->
            val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToExplanationFragment()
            v.findNavController().navigate(action)
        }
    }
}