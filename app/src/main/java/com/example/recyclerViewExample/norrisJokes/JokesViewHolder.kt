package com.example.recyclerViewExample.norrisJokes

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerViewExample.databinding.ItemJokeBinding


class JokesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemJokeBinding.bind(view)
    var lambdaJoke: ((String) -> Unit)? = null
    var lambdaJokeRemove: () -> Unit = {}


    fun showJokeList(item: String) {
        binding.joke.text = item
        // binding.remove.context
        btmRemove(item)

        binding.iconEdit.setOnClickListener {
            binding.iconEdit.visibility = View.GONE
            binding.joke.visibility = View.GONE
            binding.editText.visibility = View.VISIBLE
            binding.editText.setText(item)
            binding.cancelar.visibility = View.VISIBLE
            binding.confirmar.visibility = View.VISIBLE
            btmCancel(item)
            btmConfirm(item)


        }
    }

    fun btmCancel(item: String) {
        binding.cancelar.setOnClickListener {
            binding.editText.setText(item)
            binding.editText.visibility = View.GONE
            binding.cancelar.visibility = View.GONE
            binding.confirmar.visibility = View.GONE
            binding.joke.visibility = View.VISIBLE
            binding.iconEdit.visibility = View.VISIBLE
        }
    }

    fun btmConfirm(item: String) {
        binding.confirmar.setOnClickListener {
            binding.editText.visibility = View.GONE
            binding.cancelar.visibility = View.GONE
            binding.confirmar.visibility = View.GONE
            binding.joke.visibility = View.VISIBLE
            binding.iconEdit.visibility = View.VISIBLE
            val modifItem = binding.editText.text.toString()

            //EMISOR
            lambdaJoke?.invoke(modifItem)
        }
    }

    fun btmRemove(item: String) {
        binding.remove.setOnClickListener {
            //así se empieza poniendo un dialogo comenzamos crear una variable alertDialog
            val alertDialog = AlertDialog.Builder(binding.cancelar.context)
            alertDialog.setTitle("Remove")

            alertDialog.setMessage("You want remove the joke?:")
            alertDialog.setPositiveButton("si") { dialog, which ->
                lambdaJokeRemove?.invoke()
            }

            alertDialog.setNegativeButton("no") { dialog, which ->
                binding.editText.setText(item)
                binding.editText.visibility = View.GONE
                binding.cancelar.visibility = View.GONE
                binding.confirmar.visibility = View.GONE
                binding.joke.visibility = View.VISIBLE
                binding.iconEdit.visibility = View.VISIBLE
            }

            val dialog: AlertDialog = alertDialog.create()
            dialog.show()
        }
    }

    fun setLambda(item: (String) -> Unit) {
        // sirve para pasar el valor lambda (bloque codigo{}) desde el receptor hacia el emisor
        lambdaJoke = item
    }
    fun setLambdaRemove(item: ()->  Unit){
        lambdaJokeRemove = item
    }
}
