package com.alqosbah.android_dicoding

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

@Suppress("DEPRECATION")
class MoveWithObjectActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object)

        val person = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if(person!=null){
            val text = "Name: ${person.name.toString()}\nEmail: ${person.email.toString()},\nAge: ${person.age.toString()},\nCity: ${person.city.toString()}"
            tvObject.text = text
        }

    }

    companion object{
        const val EXTRA_PERSON = "extra person"
    }
}