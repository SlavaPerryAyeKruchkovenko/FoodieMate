package com.example.foodiemate.ui.theme.customTheme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    val primaryText: Color,
    val secondaryText: Color,
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val bottomNavigationBackground: Color,
    val bottomNavigationText: Color,
    val navigationBarIndicatorColor: Color,
    val addProductsButtonBackground: Color,
    val addProductsIconTint: Color,
    val removeProduct: Color,
    val editProduct: Color
)
