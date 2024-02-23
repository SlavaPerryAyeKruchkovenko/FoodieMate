package com.example.foodiemate.datasource.presentationModels

import com.example.foodiemate.R

sealed class Screen(val screenName: String, val label: Int, val icon: Int) {
    data object Main : Screen("main", R.string.main, R.drawable.products)
    data object Products : Screen("products", R.string.products, R.drawable.products)
    data object Recipes : Screen("recipes", R.string.recipes, R.drawable.products)
    data object Menu : Screen("menu", R.string.menu, R.drawable.products)
    data object None : Screen("none", R.string.none, R.drawable.products)
}