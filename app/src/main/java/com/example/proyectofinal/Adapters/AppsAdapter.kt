package com.example.proyectofinal.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.Model.App
import com.example.proyectofinal.R

class AppsAdapter(private val context: Context, private val apps: List<App>): RecyclerView.Adapter<AppsAdapter.AppHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_list_item,parent,false)
        return AppHolder(view)
    }

    override fun getItemCount(): Int {
        return apps.count()
    }

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bindApp(apps[position], context)
    }

    inner class AppHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val appImage: ImageView = itemView.findViewById(R.id.appImage)
        private val appName:TextView = itemView.findViewById(R.id.appName)

        fun bindApp(app:App,context: Context){
            val resourceId = context.resources.getIdentifier(app.image,"drawable", context.packageName)
            appImage.setImageResource(resourceId)
            appName.text=app.name
        }
    }
}