package com.example.recyclerViewExample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerViewExample.databinding.ActivityMainBinding
import com.example.recyclerViewExample.norrisJokes.APIService
import com.example.recyclerViewExample.norrisJokes.JokesAdapter
import com.example.recyclerViewExample.norrisJokes.NorrisJokeResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokesAdapter
    private val jokesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // muestra todos los views en la pantalla y root es su raiz de todos los views

        initRecyclerView()

        setButtonListener()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/random/")
            .addConverterFactory(GsonConverterFactory.create()) // GsonConverterFactory nos sirve para hacer la conversion de gson a nuestra clase RESPOND
            .build()
    }

    private fun getRemoteJoke() {
        val retrofit = getRetrofit()
        val service = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val call = service.getNorrisJoke("")
            val jokeResponse: NorrisJokeResponse? = call.body()
            runOnUiThread {
                if (call.isSuccessful) {

                    val joke = jokeResponse?.joke
                    if (joke != null) {
                        jokesList.add(joke)
                    } else {
                        jokesList.add("Hay un error")
                    }
                    adapter.notifyDataSetChanged()

                } else {
                    showError()
                }
            }
        }
    }

    private fun setButtonListener() {
        getRemoteJoke()
        // en el hilo principal se manipulan los views y modificaciones
        binding.btm.setOnClickListener {
            getRemoteJoke()
            setContentView(binding.root)
        }
    }

    //ojo revisar esta funcion tiene problemas con el adapter
    private fun initRecyclerView() {
        adapter = JokesAdapter(jokesList)
        binding.recyclerViewJokes.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewJokes.adapter = adapter
        binding.recyclerViewJokes.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

}
