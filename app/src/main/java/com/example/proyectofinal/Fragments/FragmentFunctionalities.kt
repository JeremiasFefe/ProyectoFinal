package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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
            R.id.settings_item -> {
                val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToFragmentSettings()
                Navigation.findNavController(v).navigate(action)
            }
            R.id.info_item -> {
                val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToFragmentInfo()
                Navigation.findNavController(v).navigate(action)
            }
            R.id.contact_item -> {
                val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToFragmentContact()
                Navigation.findNavController(v).navigate(action)
            }

            else -> Toast.makeText(activity,"not working", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }
}