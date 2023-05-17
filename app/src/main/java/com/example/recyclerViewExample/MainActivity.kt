package com.example.recyclerViewExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerViewExample.adapter.SuperHeroAdapter
import com.example.recyclerViewExample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding da acceso a los view sin tener que inicializarlo
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    fun initRecyclerView(){
        //   de esta manera se puede poner el numero de items por filas
        //   val manager =GridLayoutManager(this,    2)
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)

        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter = SuperHeroAdapter(SuperHerosProvider.superHeroList) { superHero ->
            onItemSelected(
                superHero
            )
        }
        binding.recyclerSuperHero.addItemDecoration(decoration)
    }
    fun onItemSelected(superHero: SuperHero){
        Toast.makeText(this,superHero.superHero,Toast.LENGTH_SHORT).show()

    }

}