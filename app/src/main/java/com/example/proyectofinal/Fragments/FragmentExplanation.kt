package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.*
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.ExplanationStepsAdapter
import com.example.proyectofinal.Model.ExplanationStep
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService
import kotlinx.android.synthetic.main.fragment_explanation.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentExplanation : Fragment() {
    private lateinit var v: View
    private lateinit var adapter: ExplanationStepsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var txtFuncName:TextView
    private lateinit var txtAppName:TextView

    lateinit var steps:List<ExplanationStep>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false)

        recyclerView = v.findViewById(R.id.explanationRecyclerView)
        txtAppName = v.findViewById(R.id.txtAppName)
        txtFuncName = v.findViewById(R.id.txtFuncName)

        val args = FragmentExplanationArgs.fromBundle(requireArguments())

        val appSelected = args.strAppName
        val functionalitySelected = args.strFunctionality

        for (App in DataService.apps){
            if (App.name == appSelected){
                val functionalities = DataService.getFunctionalities(App.name)
                for (Function in functionalities){
                    if (Function.title == functionalitySelected){
                        steps = Function.explanationSteps
                    }
                }
            }
        }
        //Log.d("test", steps[0].stepDescription)

        txtFuncName.text = functionalitySelected
        txtAppName.text = appSelected

        recyclerView.layoutManager = GridLayoutManager(activity,1)

        adapter = context?.let { ExplanationStepsAdapter(it, steps) }!!

        recyclerView.adapter = adapter

        setHasOptionsMenu(true)
        return v

    }

    override fun onStart() {
        super.onStart()

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