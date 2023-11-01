package com.example.foodiemate.data

import com.example.foodiemate.R

sealed class Screen(val screenName: String, val label: Int, val icon: Int) {
    object Main : Screen("main", R.string.main, R.drawable.none)
    object Fridge : Screen("fridge", R.string.fridge, R.drawable.fridge)
    object Recipes : Screen("recipes", R.string.recipes, R.drawable.recipe)
    object None : Screen("none", R.string.none, R.drawable.none)
}