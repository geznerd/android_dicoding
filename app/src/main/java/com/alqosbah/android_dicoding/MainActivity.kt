package com.alqosbah.android_dicoding

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var btnResult: Button
    private lateinit var result: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.edt_length)
        lebar = findViewById(R.id.edt_width)
        tinggi = findViewById(R.id.edt_height)
        btnResult = findViewById(R.id.btn_result)
        result = findViewById(R.id.tv_hasil)
        
        btnResult.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_result){
            val inputLength = panjang.text.toString().trim().toDouble()
            val inputWidth = lebar.text.toString().trim().toDouble()
            val inputHeight = tinggi.text.toString().trim().toDouble()
            val volume_balok = inputLength * inputWidth * inputHeight

            result.text = volume_balok.toString()
        }
    }


}
