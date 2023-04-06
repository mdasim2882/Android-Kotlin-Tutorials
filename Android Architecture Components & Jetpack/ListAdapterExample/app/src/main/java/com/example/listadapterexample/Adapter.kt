package com.example.listadapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.channels.ReceiveChannel

class Adapter(val context:Context) : ListAdapter<Item, Adapter.MyViewHolder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.initial.text = item.initial
        holder.desc.text = item.desc
        holder.holderCard.setOnClickListener {
            Toast.makeText(context,item.initial + "clicked!!!",Toast.LENGTH_LONG)
        }
    }


    // DIFF UTIL similar to comparator
    class Comparator : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    // ViewHolder
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val initial = itemView.findViewById<TextView>(R.id.txtInitial)
        val desc = itemView.findViewById<TextView>(R.id.txtDesc)
        val holderCard = itemView.findViewById<CardView>(R.id.holderCard)
    }
}
