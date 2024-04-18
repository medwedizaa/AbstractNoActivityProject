package com.example.noactivityproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.noactivityproject.databinding.ItemOfMyListBinding
import com.squareup.picasso.Picasso

class MyAdapter: Adapter<MyAdapter.MyViewHolder>() {

    private var myData: List<String> = listOf()

    fun setData(newData: List<String>) {
        myData = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemOfMyListBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount() = myData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myData[position])
    }

    class MyViewHolder(
        private val binding: ItemOfMyListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem: String) {
            Picasso.get().load(dataItem).into(binding.itemImage);

        }
    }
}