package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_explanation.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        return v

    }

    override fun onStart() {
        super.onStart()

        val appSelected = FragmentExplanationArgs.fromBundle(requireArguments()).strAppName
        val functionalitySelected = FragmentExplanationArgs.fromBundle(requireArguments()).strFunctionality

        txtFuncName.text = functionalitySelected
        txtAppName.text = appSelected
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.settings_item -> Toast.makeText(activity, "settings", Toast.LENGTH_SHORT).show()
            R.id.info_item -> Toast.makeText(activity, "info", Toast.LENGTH_SHORT).show()
            R.id.contact_item -> Toast.makeText(activity, "info", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(activity,"not working", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }
}