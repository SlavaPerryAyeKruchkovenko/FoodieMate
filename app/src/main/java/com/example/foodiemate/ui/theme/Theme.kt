package com.example.foodiemate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.customTheme.CustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.CustomShapeRadius
import com.example.foodiemate.ui.theme.customTheme.LocalCustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.LocalCustomShapeRadius

private val darkColorScheme = CustomColorsPalette(
    primaryText = Blue700,
    primaryBackground = White,
    secondaryText = Blue700,
    secondaryBackground = Blue200,
    bottomNavigationBackground = Blue500,
    bottomNavigationText = White
)

private val lightColorScheme = CustomColorsPalette(
    primaryText = Blue700,
    primaryBackground = White,
    secondaryText = Blue700,
    secondaryBackground = Blue200,
    bottomNavigationBackground = Blue500,
    bottomNavigationText = White
)

@Composable
fun FoodieMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val shapeRadius = CustomShapeRadius(
        default = 0.dp,
        card = 6.dp,
    )
    CompositionLocalProvider(
        LocalCustomColorsPalette provides colors,
        LocalCustomShapeRadius provides shapeRadius,
        content = content
    )
}