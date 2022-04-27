package com.example.kotlrecyclerview.data

data class FoodItem(
    val productCode: String,
    val name: String,
    val price: Double,
    val description: String,
    val photo: Int,
    val isHighlyRated: Boolean = false
)
