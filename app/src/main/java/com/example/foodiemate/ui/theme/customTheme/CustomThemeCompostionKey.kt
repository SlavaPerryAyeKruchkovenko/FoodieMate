package com.example.foodiemate.ui.theme.customTheme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

val LocalCustomColorsPalette = staticCompositionLocalOf {
    CustomColorsPalette(
        primaryText = Color.Unspecified,
        secondaryText = Color.Unspecified,
        primaryBackground = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        bottomNavigationBackground = Color.Unspecified,
        bottomNavigationText = Color.Unspecified,
        bottomNavigationTextSelected = Color.Unspecified,
        navigationBarIndicatorColor = Color.Unspecified,
        addProductsButtonBackground = Color.Unspecified,
        addProductsIconTint = Color.Unspecified,
        removeProduct = Color.Unspecified,
        editProduct = Color.Unspecified,
        reduceColor = Color.Unspecified,
        addColor = Color.Unspecified,
        acceptColor = Color.Unspecified,
    )
}

val LocalCustomShapeRadius = staticCompositionLocalOf {
    CustomShapeRadius(
        default = Dp.Unspecified,
        card = Dp.Unspecified,
        navigationBottomBar = Dp.Unspecified,
        iconBorderShape = Dp.Unspecified
    )
}
val LocalCustomLayoutSize = staticCompositionLocalOf {
    CustomLayoutSize(
        mediumIconSize = Dp.Unspecified,
        smallIconSize = Dp.Unspecified,
        productImageSize = Dp.Unspecified,
        navigationBottomBarHeight = Dp.Unspecified,
        addProductButtonSize = Dp.Unspecified,
        productEditorSize = Dp.Unspecified,
        bottomBarDivider = Dp.Unspecified
    )
}
val LocalCustomLayoutPadding = staticCompositionLocalOf {
    CustomLayoutPadding(
        smallPadding = Dp.Unspecified,
        mediumPadding = Dp.Unspecified,
        largePadding = Dp.Unspecified,
        cardTextPadding = Dp.Unspecified,
        smallIconPadding = Dp.Unspecified,
        mediumIconPadding = Dp.Unspecified,
        productEditorPadding = Dp.Unspecified
    )
}