package com.practice.practicamovil2.ui.components

data class ErrorMessage(
    var active: Boolean,
    val message: String? = "Unknown Error"
)