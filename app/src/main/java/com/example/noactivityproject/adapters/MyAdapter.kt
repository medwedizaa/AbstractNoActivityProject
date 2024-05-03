package com.example.noactivityproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.noactivityproject.databinding.ItemOfMyListBinding
import com.squareup.picasso.Picasso

class MyAdapter: Adapter<MyAdapter.MyViewHolder>() {

    private var myData: List<String> = listOf()
    private var callback: ((String) -> Unit)? = null

    fun setData(newData: List<String>) {
        myData = newData
        notifyDataSetChanged()
    }

    fun setCallback(newCallback: (String) -> Unit) {
        callback = newCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemOfMyListBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding, callback)
    }

    override fun getItemCount() = myData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myData[position])
    }

    class MyViewHolder(
        private val binding: ItemOfMyListBinding,
        private val callback: ((String) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            Picasso.get().load(imageUrl).into(binding.itemImage)
            binding.itemImage.setOnClickListener {
                callback?.invoke(imageUrl)
            }

        }
    }
}