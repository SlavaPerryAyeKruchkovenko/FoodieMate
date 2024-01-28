package com.example.foodiemate.ui.theme.customTheme

import androidx.compose.runtime.Composable

object FoodieMateTheme {
    val colors: CustomColorsPalette
        @Composable
        get() = LocalCustomColorsPalette.current
    val shapeRadius: CustomShapeRadius
        @Composable
        get() = LocalCustomShapeRadius.current
}