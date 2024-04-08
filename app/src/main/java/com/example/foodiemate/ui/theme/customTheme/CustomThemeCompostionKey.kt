package com.example.foodiemate.ui.theme.customTheme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

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
        addFABBackground = Color.Unspecified,
        addFABIconTint = Color.Unspecified,
        removeProductBackground = Color.Unspecified,
        editProduct = Color.Unspecified,
        reduceColor = Color.Unspecified,
        addColor = Color.Unspecified,
        acceptColor = Color.Unspecified,
        darkScreen = Color.Unspecified,
        FABBoxBackground = Color.Unspecified,
        editorBackground = Color.Unspecified,
        editorIconBackground = Color.Unspecified,
        dialogBackground = Color.Unspecified,
        dialogButtonColor = Color.Unspecified
    )
}
val LocalCustomFontSize = staticCompositionLocalOf {
    CustomFontSize(
        dialogTextFont = TextUnit.Unspecified,
        dialogTitleFont = TextUnit.Unspecified,
        noItemsFont = TextUnit.Unspecified
    )
}
val LocalCustomShapeRadius = staticCompositionLocalOf {
    CustomShapeRadius(
        default = Dp.Unspecified,
        card = Dp.Unspecified,
        navigationBottomBar = Dp.Unspecified,
        iconBorderShape = Dp.Unspecified,
        editorCorner = Dp.Unspecified,
        editorIconCorner = Dp.Unspecified,
        searchBarCorner = Dp.Unspecified
    )
}
val LocalCustomLayoutSize = staticCompositionLocalOf {
    CustomLayoutSize(
        mediumIconSize = Dp.Unspecified,
        smallIconSize = Dp.Unspecified,
        productImageSize = Dp.Unspecified,
        productTextSize = Dp.Unspecified,
        navigationBottomBarHeight = Dp.Unspecified,
        addFABSize = Dp.Unspecified,
        productEditorSize = Dp.Unspecified,
        bottomBarDividerHeight = Dp.Unspecified,
        bottomBarDividerWidth = Dp.Unspecified,
        bottomBarIcon = Dp.Unspecified,
        searchBarIcon = Dp.Unspecified,
        addFABIconSize = Dp.Unspecified,
        addFABSmallSize = Dp.Unspecified,
        addSmallFABIconSize = Dp.Unspecified,
        addFABBoxSize = Dp.Unspecified,
        loaderSize = Dp.Unspecified,
        productAppBarIcon = Dp.Unspecified,
        searchLoaderSize = Dp.Unspecified,
        dialogIcon = Dp.Unspecified
    )
}
val LocalCustomLayoutPadding = staticCompositionLocalOf {
    CustomLayoutPadding(
        smallPadding = Dp.Unspecified,
        mediumPadding = Dp.Unspecified,
        largePadding = Dp.Unspecified,
        cardPadding = Dp.Unspecified,
        cardTextPadding = Dp.Unspecified,
        cardTextBoxPadding = Dp.Unspecified,
        endCardTextPadding = Dp.Unspecified,
        smallIconPadding = Dp.Unspecified,
        mediumIconPadding = Dp.Unspecified,
        productEditorPadding = Dp.Unspecified,
        verticalNavigationBarPadding = Dp.Unspecified,
        horizontalNavigationBarPadding = Dp.Unspecified,
        addFABPadding = Dp.Unspecified,
        addFABEdgePadding = Dp.Unspecified,
        addFABCenterPadding = Dp.Unspecified,
        appBarPadding = Dp.Unspecified,
        productCardMargin = Dp.Unspecified,
        firstProductMarginTop = Dp.Unspecified
    )
}