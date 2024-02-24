package com.example.foodiemate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.customTheme.CustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.CustomLayoutPadding
import com.example.foodiemate.ui.theme.customTheme.CustomLayoutSize
import com.example.foodiemate.ui.theme.customTheme.CustomShapeRadius
import com.example.foodiemate.ui.theme.customTheme.LocalCustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.LocalCustomLayoutPadding
import com.example.foodiemate.ui.theme.customTheme.LocalCustomLayoutSize
import com.example.foodiemate.ui.theme.customTheme.LocalCustomShapeRadius

private val darkColorScheme = CustomColorsPalette(
    primaryText = Blue700,
    primaryBackground = White,
    secondaryText = Blue700,
    secondaryBackground = Blue200,
    bottomNavigationBackground = Purple900,
    bottomNavigationText = Purple500,
    bottomNavigationTextSelected = White,
    navigationBarIndicatorColor = Blue900,
    addProductsButtonBackground = Blue300,
    addProductsIconTint = Blue700,
    removeProduct = Red,
    editProduct = Orange,
    reduceColor = Red,
    addColor = Green,
    acceptColor = Green,
)

private val lightColorScheme = CustomColorsPalette(
    primaryText = Blue700,
    primaryBackground = White,
    secondaryText = Blue700,
    secondaryBackground = Blue200,
    bottomNavigationBackground = Purple900,
    bottomNavigationText = Purple500,
    bottomNavigationTextSelected = White,
    navigationBarIndicatorColor = Blue900,
    addProductsButtonBackground = Blue300,
    addProductsIconTint = Blue700,
    removeProduct = Red,
    editProduct = Orange,
    reduceColor = Red,
    addColor = Green,
    acceptColor = Green
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
        navigationBottomBar = 16.dp,
        iconBorderShape = 8.dp
    )
    val layoutSize = CustomLayoutSize(
        mediumIconSize = 24.dp,
        smallIconSize = 18.dp,
        productImageSize = 80.dp,
        navigationBottomBarHeight = 76.dp,
        addProductButtonSize = 64.dp,
        productEditorSize = 40.dp,
        bottomBarDividerHeight = 3.dp,
        bottomBarDividerWidth = 42.dp,
        bottomBarIcon = 28.dp
    )
    val layoutPadding = CustomLayoutPadding(
        smallPadding = 18.dp,
        mediumPadding = 24.dp,
        largePadding = 36.dp,
        cardTextPadding = 10.dp,
        smallIconPadding = 2.dp,
        mediumIconPadding = 3.dp,
        productEditorPadding = 4.dp,
        verticalNavigationBarPadding = 8.dp,
        horizontalNavigationBarPadding = 16.dp
    )
    CompositionLocalProvider(
        LocalCustomColorsPalette provides colors,
        LocalCustomShapeRadius provides shapeRadius,
        LocalCustomLayoutSize provides layoutSize,
        LocalCustomLayoutPadding provides layoutPadding,
        content = content
    )
}