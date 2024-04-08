package com.example.foodiemate.datasource.presentationModels

import com.example.foodiemate.R

sealed class Screen(val screenName: String, val label: Int, val icon: Int) {
    data object Products : Screen("products", R.string.products, R.drawable.products)
    data object Basket : Screen("basket", R.string.basket, R.drawable.shopping_cart)
    data object Recipes : Screen("recipes", R.string.recipes, R.drawable.recipes)
    data object Tinder : Screen("tinder", R.string.tinder, R.drawable.flame)
    data object None : Screen("none", R.string.none, R.drawable.products)
}