package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemLayoutBinding

class Adapter(var list: ArrayList<String>) : RecyclerView.Adapter<Adapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.binding.recyclerText.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateList(list1: ArrayList<String>) {
        list = ArrayList()
        list.addAll(list1)
        notifyDataSetChanged()
    }


    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLayoutBinding.bind(view)
//        var text = view.findViewById<TextView>(R.id.text)

    }




}