package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_functionalities.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentFunctionalities : Fragment() {
    lateinit var v: View
    lateinit var txtFunc : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_functionalities, container, false)

        val strAppName = FragmentFunctionalitiesArgs.fromBundle(requireArguments()).strAppName
        println(strAppName)

        txtFunc = v.findViewById(R.id.txtFunc)
        txtFunc.text = strAppName


        return v


    }
}