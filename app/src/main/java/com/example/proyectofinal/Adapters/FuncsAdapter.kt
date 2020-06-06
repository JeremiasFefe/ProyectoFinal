package com.example.proyectofinal.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Model.Functionality
import com.example.proyectofinal.R

class FuncsAdapter(private val context: Context, private val funcs:List<Functionality>, val itemClick: (Functionality)-> Unit): RecyclerView.Adapter<FuncsAdapter.FuncHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuncHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.func_list_item, parent,false)
        return FuncHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return funcs.count()
    }

    override fun onBindViewHolder(holder: FuncHolder, position: Int) {
        holder.bindFunc(funcs[position], context)
    }

    inner class FuncHolder(itemView: View, itemClick: (Functionality) -> Unit) : RecyclerView.ViewHolder(itemView){
        private val funcTxt: TextView = itemView.findViewById(R.id.txtFunc)

        fun bindFunc(func:Functionality,context: Context){
            funcTxt.text = func.title
            itemView.setOnClickListener { itemClick(func) }
        }
    }
}