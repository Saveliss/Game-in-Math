package com.example.tree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_kaltor.*
import kotlinx.android.synthetic.main.activity_main.*




class Kaltor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kaltor)

        val reut = intent.getStringExtra("right")
        val wron = intent.getStringExtra("wrong")

        Jview2.text = reut.toString()
        Jview1.text = wron.toString()









    }
}


