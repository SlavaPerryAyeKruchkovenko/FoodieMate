package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.screens.basket.model.BasketType
import com.example.foodiemate.ui.theme.customTheme.CustomModifier.tabIndicatorOffset
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasketTabs(pagerState: PagerState, tabs: MutableList<BasketType>) {
    val scope = rememberCoroutineScope()
    TabRow(modifier = Modifier.padding(top = 6.dp),
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            if (pagerState.currentPage < tabPositions.size) {
                val oldTabPosition = tabPositions[pagerState.currentPage]
                val offset = if (pagerState.currentPage == 0) {
                    CustomTheme.layoutPadding.tabFirstStartPadding
                } else {
                    0.dp
                }
                val left = oldTabPosition.left + offset + CustomTheme.layoutSize.tabRowBorder
                val indicatorWidth =
                    oldTabPosition.width - offset - CustomTheme.layoutPadding.tabEndPadding - CustomTheme.layoutSize.tabRowBorder * 2
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(left, indicatorWidth),
                    color = CustomTheme.colors.primaryBackground
                )
            }
        },
        divider = {
            HorizontalDivider(
                thickness = CustomTheme.layoutSize.tabRowBorder,
                color = CustomTheme.colors.tabRowBorder
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            BasketTabItem(pagerState, scope, tab, index)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun BasketTabsPreview() {
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    BasketTabs(pagerState, mutableListOf())
}