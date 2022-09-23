package com.practice.practicamovil2.data.repositories.game.api.models

import com.google.gson.annotations.SerializedName

data class APIGameModel (@SerializedName("title") val nombre: String,
                         @SerializedName("thumbnail") val imagen: String,
                         @SerializedName("short_description") val descripcion: String)