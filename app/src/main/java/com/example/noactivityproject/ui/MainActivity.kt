package com.example.noactivityproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.noactivityproject.R

class MainActivity : AppCompatActivity(R.layout.activity_main), NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.main_container, FirstFragment(this@MainActivity))
        }
    }

    override fun openDogDetail(imageUrl: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.main_container, DetailFragment(imageUrl))
            addToBackStack(null)
        }
    }
}