package com.example.foodiemate.datasource.presentationModels.models

data class FridgeProduct(
    val id: String,
    override val product: Product,
    override var count: Number,
    val family: Family?
) : CountedProduct
