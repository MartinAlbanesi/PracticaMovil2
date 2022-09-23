package com.practice.practicamovil2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.practicamovil2.R
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel

class GameAdapter(list: MutableLiveData<List<APIGameModel>>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var gameList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = gameList.value!!
        holder.nombre.text = list[position].nombre
        holder.descripcion.text = list[position].descripcion
        Glide.with(holder.imagen.context).load(list[position].imagen).into(holder.imagen)
    }

    override fun getItemCount(): Int {
        return gameList.value!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView
        var descripcion: TextView
        var imagen: ImageView

        init {
            nombre = itemView.findViewById(R.id.tv_nombre)
            descripcion = itemView.findViewById(R.id.tv_descripcion)
            imagen = itemView.findViewById(R.id.iv_imagen)
        }
    }

}