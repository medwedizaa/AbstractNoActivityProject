package com.example.noactivityproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noactivityproject.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment(
    private val imageUrl: String
): Fragment() {

    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { nonNullableBinding ->
            Picasso.get().load(imageUrl).into(nonNullableBinding.detailImage)
        }
    }
}