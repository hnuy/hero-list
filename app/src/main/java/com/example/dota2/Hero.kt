package com.example.dota2

data class Hero(
    val id: String,
    val name: String,
    val portrait: Portrait
)

data class Portrait(
    val full: String,
    val vert: String
)
