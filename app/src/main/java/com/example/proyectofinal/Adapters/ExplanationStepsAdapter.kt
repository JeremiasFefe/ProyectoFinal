package com.example.proyectofinal.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinal.Model.ExplanationStep
import com.example.proyectofinal.R

class ExplanationStepsAdapter(private val context: Context, private val steps:List<ExplanationStep>): RecyclerView.Adapter<ExplanationStepsAdapter.StepHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.explanation_list_item, parent,false)
        return StepHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: StepHolder, position: Int) {
        holder.bindStep(steps[position], context)
    }

    inner class StepHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val stepImage: ImageView = itemView.findViewById(R.id.stepImage)

        fun bindStep(step: ExplanationStep, context: Context){
            //val resourceId = context.resources.getIdentifier(step.stepImage,"drawable",context.packageName)
            //stepImage.setImageResource(resourceId)

        }
    }
}