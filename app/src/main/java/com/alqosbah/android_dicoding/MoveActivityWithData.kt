package com.alqosbah.android_dicoding

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityWithData : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data2)

        val tvData: TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getStringExtra(EXTRA_AGE)

        tvData.text = "Nama: $name, dan Umur: $age"
    }


companion object{
        const val EXTRA_NAME = "Name"
        const val EXTRA_AGE = "Age"
    }
}