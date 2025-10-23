package com.example.gestionlivres.data

data class Book(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val year: Int = 0,
    val description: String = "",
    val coverPath: String = "",
    val read: Boolean = false
)
