package com.practice.practicamovil2.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.practicamovil2.R
import com.practice.practicamovil2.data.model.GameModel

class GameAdapter(list: List<GameModel>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var gameList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text =  gameList[position].nombre
        holder.descripcion.text = gameList[position].descripcion
        Glide.with(holder.imagen.context).load(gameList[position].imagen).into(holder.imagen)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView
        var descripcion: TextView
        var imagen: ImageView
        init{
            nombre = itemView.findViewById(R.id.tv_nombre)
            descripcion = itemView.findViewById(R.id.tv_descripcion)
            imagen = itemView.findViewById(R.id.iv_imagen)
        }
    }

}