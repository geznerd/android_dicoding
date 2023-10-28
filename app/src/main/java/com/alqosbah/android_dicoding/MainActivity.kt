package com.alqosbah.android_dicoding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithData: Button = findViewById(R.id.btn_move_with_data)
        btnMove.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java )
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> {
                val moveWithData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                moveWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Hanjaya")
                moveWithData.putExtra(MoveActivityWithData.EXTRA_AGE, "19")
                startActivity(moveWithData)

            }
        }
    }
}