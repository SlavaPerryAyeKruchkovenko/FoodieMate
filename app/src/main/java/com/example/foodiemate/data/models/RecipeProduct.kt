package com.example.foodiemate.data.models

data class RecipeProduct(
    val id: String,
    val product: Product,
    val count: Double,
    val type: RecipeProductCountType
)
