package com.example.foodiemate.datasource.presentationModels.models

data class FridgeProduct(
    val id: String,
    val product: Product,
    var count: Number,
    val family: Family?
)
