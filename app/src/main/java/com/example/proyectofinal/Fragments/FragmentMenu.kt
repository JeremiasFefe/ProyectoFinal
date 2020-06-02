package com.example.proyectofinal.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        recyclerView.layoutManager = GridLayoutManager(activity,2)

        adapter = context?.let {
            AppsAdapter(it,DataService.apps){app->
                val action = FragmentMenuDirections.actionMenuFragmentToFunctionalitiesFragment(app.name)
                Navigation.findNavController(v).navigate(action)
            }
        }!!

        recyclerView.adapter = adapter
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
            R.id.settings_item -> Toast.makeText(activity, "settings", Toast.LENGTH_SHORT).show()
            R.id.info_item -> Toast.makeText(activity, "info", Toast.LENGTH_SHORT).show()
            R.id.contact_item -> Toast.makeText(activity, "info", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(activity,"not working", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }

}