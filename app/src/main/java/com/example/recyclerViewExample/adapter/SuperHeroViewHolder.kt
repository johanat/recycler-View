package com.example.recyclerViewExample.adapter


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerViewExample.R
import com.example.recyclerViewExample.SuperHero
import com.example.recyclerViewExample.databinding.ItemSuperheroBinding


class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)


    fun render(superHeroModel: SuperHero, onClickListener  : (SuperHero)-> Unit) {
        // binding muestra de forma mas directa todos los archivos de diseño atraves de la instancia  de la clase de enlace
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher

        Glide
            .with(binding.ivSuperHero.context)
            .load(superHeroModel.photo)
            .placeholder(R.drawable.ic_placeholder)
            .into(binding.ivSuperHero)


        itemView.setOnClickListener {onClickListener(superHeroModel) }
    }
}