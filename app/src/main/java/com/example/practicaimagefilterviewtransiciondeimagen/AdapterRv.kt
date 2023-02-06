package com.example.practicaimagefilterviewtransiciondeimagen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class AdapterRv(
    var listItems: MutableList<Item>,
    private var context: Context,
    var onClick: (View) -> Unit
) :
    RecyclerView.Adapter<AdapterRv.AdapterViewHolder>() {


    class AdapterViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
        val name = itemView.findViewById<TextView>(R.id.nameContact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        var itemList = listItems[position]
        holder.name.text = itemList.name
        holder.itemView.transitionName = "$position"
        holder.name.setOnClickListener {
            onClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int = listItems.size

}