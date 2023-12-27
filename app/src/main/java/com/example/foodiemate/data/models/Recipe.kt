package com.example.foodiemate.data.models

import java.util.Date

data class Recipe(
    val id: String,
    val author: User,
    val kbZhURecipe: KBZhURecipe,
    val category: RecipeCategory,
    val name: String,
    val score: Double,
    val status: VisibleStatus,
    val description: String,
    val image: String,
    val recipeSteps: List<RecipeStep>,
    val recipeProducts: List<RecipeProduct>,
    val date: Date,
    var isFollow: Boolean,
)