package com.example.pulltorefresh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Item_adpater(val items:ArrayList<String>, val context:Context):RecyclerView.Adapter<Item_adpater.ItemViewholder>() {

    // viewholder class containing all the instances of the view
    inner class ItemViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text1)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false)
        val viewHolder = ItemViewholder(view)
        viewHolder.deleteButton.setOnClickListener{
            onItemClicked(items[viewHolder.adapterPosition], items)
            updateList()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val currentItem = items[position] // this current item will be a string
        holder.textView.text = currentItem // set the text of the text box to currentItem
    }

    override fun getItemCount(): Int {
       return items.size
    }

    fun updateList(){
        notifyDataSetChanged()
    }
}


private fun onItemClicked(item: String, items: ArrayList<String>) {
    for(i in items ){
        if(i==item){
            items.remove(i)
            break
        }
    }
}



