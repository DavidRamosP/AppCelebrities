package com.cibertec.repasorecyclerviewactivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.repasorecyclerviewactivity.Celebrity
import com.cibertec.repasorecyclerviewactivity.R

class AdapterCel(private var celebrities:List<Celebrity>, private val click:(Celebrity)->Unit, private val borrar:(Int)->Unit) : RecyclerView.Adapter<ViewHolderCel>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCel {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderCel(layoutInflater.inflate(R.layout.item_celebrity,parent, false))
    }

    override fun getItemCount(): Int {
       return celebrities.count()
    }

    override fun onBindViewHolder(holder: ViewHolderCel, position: Int) {
        val item = celebrities[position]
        holder.render(item,{
            click(item)
        },{ borrar(it) })
    }

    fun updateLista(listaNueva: List<Celebrity>){
        this.celebrities = listaNueva
        notifyDataSetChanged()
    }
}