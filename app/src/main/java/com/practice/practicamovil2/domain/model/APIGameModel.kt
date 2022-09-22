package com.practice.practicamovil2.domain.model

import com.google.gson.annotations.SerializedName

data class APIGameModel (@SerializedName("id") val nombre: String,
                         @SerializedName("url") val imagen: String,
                         @SerializedName("width") val descripcion: String)