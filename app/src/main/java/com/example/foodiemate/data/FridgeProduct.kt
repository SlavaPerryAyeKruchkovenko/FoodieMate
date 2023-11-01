package com.example.foodiemate.data

import java.util.*

data class FridgeProduct(
    val id: String,
    val product: Product,
    val count: Number,
    val important: Boolean,
    val minCount: Int,
    val createdDate: Date,
    val delayOfTime: Date?,
)
