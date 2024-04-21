package com.example.foodiemate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
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
    primaryBackground = RebeccaPurpleLight,
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
    addColor = Green700,
    acceptColor = Green700,
    darkScreen = Dark,
    FABBoxBackground = LightPurple900,
    editorBackground = PurpleHeart,
    editorIconBackground = TransGray,
    dialogBackground = LightAmethyst,
    dialogButtonColor = Purple900,
    tabUnselected = Gray,
    tabRowBorder = Gray
)

private val lightColorScheme = CustomColorsPalette(
    primaryText = Black,
    primaryBackground = White,
    secondaryText = Black,
    secondaryBackground = LightGray,
    bottomNavigationBackground = WhiteSmoke,
    bottomNavigationText = Black,
    bottomNavigationTextSelected = Green700,
    navigationBarIndicatorColor = Color.Red,//useless
    addFABBackground = Green500,
    addFABIconTint = White,
    removeProductBackground = DimRed,
    editProduct = Black,
    reduceColor = Red,
    addColor = Green700,
    acceptColor = Green700,
    darkScreen = Dark,
    FABBoxBackground = DimGreen,
    editorBackground = Green500,
    editorIconBackground = TransGray,
    dialogBackground = LightGray,
    dialogButtonColor = Green700,
    tabUnselected = Gray,
    tabRowBorder = Gray
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
        searchBarCorner = 10.dp,
        basketCorner = 8.dp
    )
    val layoutSize = CustomLayoutSize(
        mediumIconSize = 24.dp,
        smallIconSize = 18.dp,
        productCardSize = 96.dp,
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
        dialogIcon = 18.dp,
        basketTab = 30.dp,
        tabIcon = 20.dp,
        tabRowBorder = 2.dp,
        basketProductImageSize = 64.dp,
        basketCheckBoxSize = 56.dp
    )
    val layoutPadding = CustomLayoutPadding(
        smallPadding = 18.dp,
        mediumPadding = 24.dp,
        largePadding = 36.dp,
        cardPadding = 8.dp,
        cardTextPadding = 4.dp,
        productCardDividerPadding = 4.dp,
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
        firstProductMarginTop = 12.dp,
        tabFirstStartPadding = 2.dp,
        tabEndPadding = 6.dp
    )
    val fontSize = CustomFontSize(
        dialogTitleFont = 18.sp,
        dialogTextFont = 16.sp,
        noItemsFont = 32.sp,
        bottomBarItemFont = 15.sp,
        basketTabFont = 18.sp,
        basketTabLineHeight = 20.sp
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