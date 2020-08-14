package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.FuncsAdapter
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService

/**
 * A simple [Fragment] subclass.
 */
class FragmentFunctionalities : Fragment() {
    private lateinit var v: View
    private lateinit var funcsAdapter: FuncsAdapter
    private lateinit var recFuncs: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var txtFunc: TextView
    private lateinit var imgAppLogo:ImageView
    private lateinit var appName: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_functionalities, container, false)

        recFuncs = v.findViewById(R.id.recFunctionalities)
        txtFunc= v.findViewById(R.id.txtFunc)
        imgAppLogo = v.findViewById(R.id.imgAppLogo)
        return v
    }

    override fun onStart() {
        super.onStart()

        recFuncs.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(context)
        recFuncs.layoutManager = linearLayoutManager

        val appSelected = FragmentFunctionalitiesArgs.fromBundle(requireArguments()).appSelected
        appName = appSelected.name.toString()
        funcsAdapter = FuncsAdapter(requireContext(),DataService.getFunctionalities(appName)){
            Functionality -> val action = FragmentFunctionalitiesDirections.actionFunctionalitiesFragmentToExplanationFragment(Functionality, appName)
            Navigation.findNavController(v).navigate(action)
        }

        recFuncs.adapter = funcsAdapter

        txtFunc.text = appSelected.name
        val resourceId = v.resources.getIdentifier(appSelected.image,"drawable", requireContext().packageName)
        imgAppLogo.setImageResource(resourceId)

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