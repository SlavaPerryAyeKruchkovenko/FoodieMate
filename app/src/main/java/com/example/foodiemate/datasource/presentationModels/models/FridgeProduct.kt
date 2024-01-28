package com.example.foodiemate.datasource.presentationModels.models

data class FridgeProduct(
    val id: String,
    val product: Product,
    val count: Number,
    val family: Family
)
