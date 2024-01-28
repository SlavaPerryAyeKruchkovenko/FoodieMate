package com.example.foodiemate.datasource.presentationModels

import com.example.foodiemate.R

sealed class Screen(val screenName: String, val label: Int, val icon: Int) {
    data object Fridge : Screen("fridge", R.string.fridge, R.drawable.fridge)
    data object Recipes : Screen("recipes", R.string.recipes, R.drawable.recipe)
    data object None : Screen("none", R.string.none, R.drawable.none)
}