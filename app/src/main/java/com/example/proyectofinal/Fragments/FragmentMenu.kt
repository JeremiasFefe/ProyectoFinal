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
    private lateinit var appsAdapter: AppsAdapter
    private lateinit var recApps: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager

    @SuppressLint("RestrictedApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false)

        recApps = v.findViewById(R.id.recApps)


        return v
    }

    override fun onStart() {
        super.onStart()

        recApps.setHasFixedSize(true)
        var spanCount = 2

        gridLayoutManager = GridLayoutManager(context,spanCount)
        recApps.layoutManager = gridLayoutManager

        appsAdapter = AppsAdapter(requireContext(),DataService.apps){app->
            val action = FragmentMenuDirections.actionMenuFragmentToFunctionalitiesFragment(app)
            Navigation.findNavController(v).navigate(action)
        }

        recApps.adapter = appsAdapter

        setHasOptionsMenu(true)
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