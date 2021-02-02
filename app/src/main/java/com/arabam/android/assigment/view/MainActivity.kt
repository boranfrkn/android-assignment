package com.arabam.android.assigment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arabam.android.assigment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setTitle(null)
    }
}
