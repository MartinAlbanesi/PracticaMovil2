package com.practice.practicamovil2.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.practicamovil2.R
import com.practice.practicamovil2.domain.model.APIGameModel

class GameAdapter(list: List<APIGameModel>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var gameList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        Log.d("GameAdapter","Entró al onCreateViewHolder() exitosamente")
        return ViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text =  gameList[position].nombre
        holder.descripcion.text = gameList[position].descripcion
        Glide.with(holder.imagen.context).load(gameList[position].imagen).into(holder.imagen)
        Log.d("GameAdapter","Entró al onBindViewHolder() exitosamente")
    }

    override fun getItemCount(): Int {
        Log.d("GameAdapter","Entró al getItemCount() exitosamente")
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
            Log.d("GameAdapter","Se inicializan las vistas del ViewHolder() exitosamente")
        }
    }

}