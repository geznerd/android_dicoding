package com.alqosbah.android_dicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Hero>()
    private lateinit var rvHeroes: RecyclerView
    //private lateinit var listHeroAdapter : ListHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        // memanggil heroes
        list.addAll(getListHeroes())
        showRecyclerList()

    }

    private fun getListHeroes(): ArrayList<Hero>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescriptipn = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices){
            val hero = Hero(dataName[i], dataDescriptipn[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }

        return  listHero
    }

    private fun showRecyclerList(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }
}