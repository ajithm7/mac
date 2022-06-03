package com.example.android.trackmysleepquality.sleeptracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter(val context: Context,val list:List<SleepNight>):RecyclerView.Adapter<TextItemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false)
        return TextItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        holder.addToView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class TextItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    fun addToView(sleepNight:SleepNight){
        itemView.findViewById<TextView>(R.id.itemTextView).text=sleepNight.nightId.toString()
    }

}