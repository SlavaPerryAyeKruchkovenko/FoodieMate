package com.example.foodiemate.utils

import com.example.foodiemate.R
import com.example.foodiemate.data.Product

object ProductUtils {
    fun getProductImage(product: Product): Int {
        return when (product.category.lowercase()) {
            "vegetables" -> R.drawable.vegetables
            "fruits" -> R.drawable.fruits
            "sausage" -> R.drawable.meat
            "meat" -> R.drawable.meat
            "cheese" -> R.drawable.cheese
            "milk" -> R.drawable.milk
            else -> R.drawable.product
        }
    }
}