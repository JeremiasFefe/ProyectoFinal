package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.ExplanationStepsAdapter
import com.example.proyectofinal.Model.ExplanationStep
import com.example.proyectofinal.R

/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    private lateinit var v: View
    private lateinit var adapter: ExplanationStepsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var txtFuncName:TextView
    //private lateinit var txtAppName:TextView

    private lateinit var steps:List<ExplanationStep>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        recyclerView = v.findViewById(R.id.explanationRecyclerView)
        //txtAppName = v.findViewById(R.id.txtAppName)
        txtFuncName = v.findViewById(R.id.txtFuncName)

        val args = FragmentExplanationArgs.fromBundle(requireArguments())
        val functionalitySelected = args.functionality
        steps = functionalitySelected.explanationSteps


        txtFuncName.text = functionalitySelected.title

        recyclerView.layoutManager = GridLayoutManager(activity,1)

        adapter = context?.let { ExplanationStepsAdapter(it, steps) }!!

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