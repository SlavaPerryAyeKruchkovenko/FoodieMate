package com.example.foodiemate.ui.theme.customTheme

import androidx.compose.runtime.Composable

object CustomTheme {
    val colors: CustomColorsPalette
        @Composable
        get() = LocalCustomColorsPalette.current
    val shapeRadius: CustomShapeRadius
        @Composable
        get() = LocalCustomShapeRadius.current
    val layoutSize: CustomLayoutSize
        @Composable
        get() = LocalCustomLayoutSize.current
    val layoutPadding: CustomLayoutPadding
        @Composable
        get() = LocalCustomLayoutPadding.current
    val fontSize: CustomFontSize
        @Composable
        get() = LocalCustomFontSize.current
}