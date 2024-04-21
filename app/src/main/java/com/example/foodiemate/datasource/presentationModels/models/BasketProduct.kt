package com.example.foodiemate.datasource.presentationModels.models

data class BasketProduct(
    val id: String,
    override val product: Product,
    override var count: Number,
    var selected: Boolean,
    val family: Family?
) : CountedProduct
