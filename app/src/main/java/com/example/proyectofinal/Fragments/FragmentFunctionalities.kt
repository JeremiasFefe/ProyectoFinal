package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.FuncsAdapter
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService

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
        recyclerView.setHasFixedSize(true)


        txtFunc= v.findViewById(R.id.txtFunc)
        recyclerView.layoutManager = GridLayoutManager(activity,1)

        val appSelected = FragmentFunctionalitiesArgs.fromBundle(requireArguments()).strAppName
        adapter = context?.let {
            FuncsAdapter(it,DataService.getFunctionalities(appSelected)){Functionality ->
                val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToExplanationFragment(Functionality, appSelected)
                Navigation.findNavController(v).navigate(action)
            }
        }!!

        recyclerView.adapter = adapter
        txtFunc.text = appSelected

        setHasOptionsMenu(true)

        return v
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