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

        if(savedInstanceState != null){
            val resulta = savedInstanceState.getString(STATE_RESULT)
            result.text = resulta
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_result){
            val inputLength = panjang.text.toString().trim()
            val inputWidth = lebar.text.toString().trim()
            val inputHeight = tinggi.text.toString().trim()
            var isEmptyFields = false

            if (inputLength.isEmpty()){
                isEmptyFields = true
                panjang.error = "Bagian ini harus diisi"
                result.text = getString(R.string.ada_bagian_yang_belum_diisi)
            }

            if (inputWidth.isEmpty()){
                isEmptyFields = true
                lebar.error = "Bagian ini harus diisi"
                result.text = getString(R.string.ada_bagian_yang_belum_diisi)
            }

            if(inputHeight.isEmpty()){
                isEmptyFields = true
                tinggi.error = "Bagian ini harus diisi"
                result.text = getString(R.string.ada_bagian_yang_belum_diisi)
            }

            if (!isEmptyFields){
                val volume_balok = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()

                result.text = volume_balok.toString()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }

    companion object{
        private val STATE_RESULT = "state result"
    }


}
