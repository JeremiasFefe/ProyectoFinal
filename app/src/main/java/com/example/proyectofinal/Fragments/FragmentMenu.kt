package com.example.proyectofinal.Fragments

import android.app.Activity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Adapters.AppsAdapter
import com.example.proyectofinal.R
import com.example.proyectofinal.Services.DataService
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentMenu : Fragment() {
    private lateinit var v: View
    private lateinit var adapter: AppsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false)

        recyclerView = v.findViewById(R.id.appListView)

        recyclerView.layoutManager = GridLayoutManager(activity,2)

        adapter = context?.let { AppsAdapter(it,DataService.apps) }!!

        recyclerView.adapter = adapter
        return v
    }
}