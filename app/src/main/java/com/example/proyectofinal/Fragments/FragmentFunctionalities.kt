package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.FuncsAdapter
import com.example.proyectofinal.Model.Functionality
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService
import kotlinx.android.synthetic.main.fragment_functionalities.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentFunctionalities : Fragment() {
    private lateinit var v: View
    private lateinit var adapter: FuncsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var txtFunc: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_functionalities, container, false)

        recyclerView = v.findViewById(R.id.funcListView)
        txtFunc= v.findViewById(R.id.txtFunc)
        recyclerView.layoutManager = GridLayoutManager(activity,1)

        val appSelected = FragmentFunctionalitiesArgs.fromBundle(requireArguments()).strAppName
        adapter = context?.let {
            FuncsAdapter(it,DataService.getFunctionalities(appSelected)){Functionality ->
                val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToExplanationFragment(Functionality.title, appSelected)
                Navigation.findNavController(v).navigate(action)
            }
        }!!

        recyclerView.adapter = adapter
        txtFunc.text = appSelected

        return v
    }

    override fun onStart() {
        super.onStart()


    }
}