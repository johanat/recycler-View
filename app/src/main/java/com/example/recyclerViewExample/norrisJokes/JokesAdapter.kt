package com.example.recyclerViewExample.norrisJokes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerViewExample.R

class JokesAdapter(private val listModify: MutableList<String>) :
    RecyclerView.Adapter<JokesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JokesViewHolder(layoutInflater.inflate(R.layout.item_joke, parent, false))

    }

    override fun getItemCount(): Int {
        return listModify.size
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        val item = listModify[position]

        //RECEPTOR
        holder.showJokeList(item)
        holder.setLambda { modifiedJoke ->
            listModify.set(position, modifiedJoke)
            notifyItemChanged(position) // cuando se modifica las lista siempre se manda a esta funcion
        }
        holder.setLambdaRemove {
            notifyDataSetChanged()
            listModify.removeAt(position)
        }
    }
}