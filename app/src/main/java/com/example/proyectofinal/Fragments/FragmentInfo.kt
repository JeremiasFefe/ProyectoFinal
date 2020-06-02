package com.example.proyectofinal.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_explanation.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentInfo : Fragment() {
    lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_info, container, false)

        return v

    }

    override fun onStart() {
        super.onStart()
    }
}