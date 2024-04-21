package com.example.foodiemate.datasource.presentationModels.models

data class BasketProduct(
    val id: String,
    val product: Product,
    var count: Number,
    var selected: Boolean,
    val family: Family?
)
