package com.example.proyectofinal.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.AppsAdapter
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService


/**
 * A simple [Fragment] subclass.
 */
class FragmentMenu : Fragment() {
    private lateinit var v: View
    private lateinit var adapter: AppsAdapter
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("RestrictedApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false)

        recyclerView = v.findViewById(R.id.txtDescrMenu)

        recyclerView.setHasFixedSize(true)
        var spanCount = 2

        recyclerView.layoutManager = GridLayoutManager(activity,spanCount)

        adapter = context?.let {
            AppsAdapter(it,DataService.apps){app->
                val action = FragmentMenuDirections.actionMenuFragmentToFunctionalitiesFragment(app)
                Navigation.findNavController(v).navigate(action)
            }
        }!!

        recyclerView.adapter = adapter

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