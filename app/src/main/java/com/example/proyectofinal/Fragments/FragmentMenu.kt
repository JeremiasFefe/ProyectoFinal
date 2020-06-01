package com.example.proyectofinal.Fragments

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
class FragmentMenu : Fragment() {
    lateinit var v: View
    lateinit var btnMenuToFunc: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false)
        btnMenuToFunc = v.findViewById(R.id.btn_menu_to_func)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnMenuToFunc.setOnClickListener { v ->
            val action = FragmentMenuDirections.actionMenuFragmentToFunctionalitiesFragment()
            v.findNavController().navigate(action)
        }
    }
}