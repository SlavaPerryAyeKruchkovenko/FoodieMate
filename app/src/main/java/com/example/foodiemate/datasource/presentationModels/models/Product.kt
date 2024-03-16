package com.example.foodiemate.datasource.presentationModels.models

data class Product(
    val id: String,
    val category: ProductCategory,
    val name: String,
    var unit: UnitOfMeasure
)
