package com.example.foodiemate.data.models

data class Product(
    val id: String,
    val category: String,
    val subCategory: String,
    val brand: String?,
    val name: String,
    val unitId: String
)
