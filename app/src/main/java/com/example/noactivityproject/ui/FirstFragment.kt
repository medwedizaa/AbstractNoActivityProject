package com.example.noactivityproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noactivityproject.databinding.FragmentFirstBinding
import com.example.noactivityproject.ui.adapters.MyAdapter
import com.example.noactivityproject.ui.network.ApiClient

class FirstFragment: Fragment() {
    private var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val networkClient = ApiClient()
        networkClient.initClient()

        binding?.fragmentButton?.setOnClickListener {
            Log.i("MY_TAG", "My message with additional information about my application")
        }

        binding?.myList?.layoutManager = LinearLayoutManager(binding?.myList?.context ?: requireContext())
        val myAdapter: MyAdapter = MyAdapter()
        binding?.myList?.adapter = myAdapter

        networkClient.getPicturesList { pictureList ->
            Log.i("MY_TAG", "My dog picture list contains ${pictureList?.size}")
            if (pictureList != null) {
                myAdapter.setData(pictureList)
            }
        }

//        myAdapter.setData(listOf("String1", "Other string", "Third string"))
    }
}