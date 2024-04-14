package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.screens.basket.model.BasketType
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasketTabItem(pagerState: PagerState, scope: CoroutineScope, tab: BasketType, index: Int) {
    val cornerShape = RoundedCornerShape(
        topStart = CustomTheme.shapeRadius.basketCorner,
        topEnd = CustomTheme.shapeRadius.basketCorner
    )
    val isSelected = pagerState.currentPage == index
    val tabBackground = if (isSelected) {
        CustomTheme.colors.tabSelected
    } else {
        CustomTheme.colors.secondaryBackground
    }
    LeadingIconTab(
        modifier = Modifier
            .clip(cornerShape)
            .background(tabBackground)
            .height(CustomTheme.layoutSize.basketTab)
            .border(
                1.dp,
                CustomTheme.colors.primaryText,
                cornerShape
            ),
        selectedContentColor = CustomTheme.colors.primaryText,
        unselectedContentColor = CustomTheme.colors.primaryText,
        icon = {
            Icon(
                modifier = Modifier.size(CustomTheme.layoutSize.tabIcon),
                painter = painterResource(id = tab.icon),
                contentDescription = stringResource(id = tab.title)
            )
        },
        text = {
            Text(
                text = stringResource(id = tab.title),
                fontSize = CustomTheme.fontSize.basketTabFont,
                lineHeight = CustomTheme.fontSize.basketTabLineHeight
            )
        },
        selected = isSelected,
        onClick = {
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        },
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PreviewBasketTabItem() {
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    val scope = rememberCoroutineScope()
    BasketTabItem(pagerState, scope, BasketType.PersonalBasket, 0)
}