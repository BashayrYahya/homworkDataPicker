package com.example.myhomworkdatapicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment= PickFragment ()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView,fragment)
            .commit()

    }
}