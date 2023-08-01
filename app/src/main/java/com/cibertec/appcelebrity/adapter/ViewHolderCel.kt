package com.cibertec.appcelebrity.adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.inflate
import com.bumptech.glide.Glide
import com.cibertec.appcelebrity.Celebrity
import com.cibertec.appcelebrity.R
import com.cibertec.appcelebrity.databinding.ItemCelebrityBinding


class ViewHolderCel(view:View) :RecyclerView.ViewHolder(view) {

    private val binding = ItemCelebrityBinding.bind(view)
    val name = binding.tvName
    val email = binding.tvEmail
    val imageUrl = binding.ivCelebrity
    private val btnBorrar = binding.btnBorrar

    fun render(celebrity: Celebrity, click:(Celebrity)->Unit, borrar:(Int)->Unit){
        name.text = celebrity.nombre
        email.text = celebrity.email
        itemView.setOnClickListener { click(celebrity) }
        Glide.with(imageUrl.context).load(celebrity.urlImage).into(imageUrl)
        btnBorrar.setOnClickListener { borrar(adapterPosition) }
    }
}