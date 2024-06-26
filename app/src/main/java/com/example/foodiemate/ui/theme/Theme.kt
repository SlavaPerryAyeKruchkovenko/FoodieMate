package com.example.foodiemate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.ui.theme.customTheme.CustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.CustomFontSize
import com.example.foodiemate.ui.theme.customTheme.CustomLayoutPadding
import com.example.foodiemate.ui.theme.customTheme.CustomLayoutSize
import com.example.foodiemate.ui.theme.customTheme.CustomShapeRadius
import com.example.foodiemate.ui.theme.customTheme.LocalCustomColorsPalette
import com.example.foodiemate.ui.theme.customTheme.LocalCustomFontSize
import com.example.foodiemate.ui.theme.customTheme.LocalCustomLayoutPadding
import com.example.foodiemate.ui.theme.customTheme.LocalCustomLayoutSize
import com.example.foodiemate.ui.theme.customTheme.LocalCustomShapeRadius

private val darkColorScheme = CustomColorsPalette(
    primaryText = Black,
    primaryBackground = RebeccaPurple,
    secondaryText = White,
    secondaryBackground = BrightLavender,
    bottomNavigationBackground = Purple900,
    bottomNavigationText = Purple500,
    bottomNavigationTextSelected = White,
    navigationBarIndicatorColor = Blue900,
    addFABBackground = Purple900,
    addFABIconTint = White,
    removeProductBackground = Red,
    editProduct = Black,
    reduceColor = Red,
    addColor = Green,
    acceptColor = Green,
    darkScreen = Dark,
    FABBoxBackground = LightPurple900,
    editorBackground = PurpleHeart,
    editorIconBackground = TransGray,
    dialogBackground = LightAmethyst,
    dialogButtonColor = Purple900
)

private val lightColorScheme = CustomColorsPalette(
    primaryText = Black,
    primaryBackground = RebeccaPurple,
    secondaryText = White,
    secondaryBackground = BrightLavender,
    bottomNavigationBackground = Purple900,
    bottomNavigationText = Purple500,
    bottomNavigationTextSelected = White,
    navigationBarIndicatorColor = Blue900,
    addFABBackground = Purple900,
    addFABIconTint = White,
    removeProductBackground = LightRed,
    editProduct = Black,
    reduceColor = Red,
    addColor = Green,
    acceptColor = Green,
    darkScreen = Dark,
    FABBoxBackground = LightPurple900,
    editorBackground = PurpleHeart,
    editorIconBackground = TransGray,
    dialogBackground = LightAmethyst,
    dialogButtonColor = Purple900
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
        card = 12.dp,
        navigationBottomBar = 16.dp,
        iconBorderShape = 8.dp,
        editorCorner = 9.dp,
        editorIconCorner = 5.dp,
        searchBarCorner = 10.dp
    )
    val layoutSize = CustomLayoutSize(
        mediumIconSize = 24.dp,
        smallIconSize = 18.dp,
        productImageSize = 96.dp,
        productTextSize = 58.dp,
        navigationBottomBarHeight = 76.dp,
        addFABSize = 56.dp,
        productEditorSize = 40.dp,
        bottomBarDividerHeight = 3.dp,
        bottomBarDividerWidth = 42.dp,
        bottomBarIcon = 28.dp,
        searchBarIcon = 28.dp,
        addFABIconSize = 24.dp,
        addFABSmallSize = 40.dp,
        addSmallFABIconSize = 18.dp,
        addFABBoxSize = 200.dp,
        loaderSize = 200.dp,
        productAppBarIcon = 56.dp,
        searchLoaderSize = 56.dp,
        dialogIcon = 18.dp
    )
    val layoutPadding = CustomLayoutPadding(
        smallPadding = 18.dp,
        mediumPadding = 24.dp,
        largePadding = 36.dp,
        cardPadding = 8.dp,
        cardTextPadding = 4.dp,
        cardTextBoxPadding = 4.dp,
        endCardTextPadding = 28.dp,
        smallIconPadding = 4.dp,
        mediumIconPadding = 3.dp,//useless
        productEditorPadding = 5.dp,
        verticalNavigationBarPadding = 8.dp,
        horizontalNavigationBarPadding = 16.dp,
        addFABPadding = 16.dp,
        addFABEdgePadding = 24.dp,
        addFABCenterPadding = 64.dp,
        appBarPadding = 12.dp,
        productCardMargin = 8.dp,
        firstProductMarginTop = 12.dp
    )
    val fontSize = CustomFontSize(
        dialogTitleFont = 18.sp,
        dialogTextFont = 16.sp,
        noItemsFont = 32.sp,
        bottomBarItemFont = 15.sp
    )
    CompositionLocalProvider(
        LocalCustomColorsPalette provides colors,
        LocalCustomShapeRadius provides shapeRadius,
        LocalCustomLayoutSize provides layoutSize,
        LocalCustomLayoutPadding provides layoutPadding,
        LocalCustomFontSize provides fontSize,
        content = content
    )
}