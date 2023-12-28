package com.example.foodiemate.utils

import androidx.compose.ui.graphics.Color
import com.example.foodiemate.ui.theme.*

object RecipeUtils {
    fun getRecipeScoreColor(score: Double): Color {
        return if (score > 4) {
            BigScore
        } else if (score > 3) {
            MediumScore
        } else {
            LowScore
        }
    }
}