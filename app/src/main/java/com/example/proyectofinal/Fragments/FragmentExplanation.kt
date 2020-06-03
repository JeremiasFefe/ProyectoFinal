package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_explanation.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    private lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        setHasOptionsMenu(true)
        return v

    }

    override fun onStart() {
        super.onStart()

        val appSelected = FragmentExplanationArgs.fromBundle(requireArguments()).strAppName
        val functionalitySelected = FragmentExplanationArgs.fromBundle(requireArguments()).strFunctionality

        txtFuncName.text = functionalitySelected
        txtAppName.text = appSelected
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
                || super.onOptionsItemSelected(item)

    }
}