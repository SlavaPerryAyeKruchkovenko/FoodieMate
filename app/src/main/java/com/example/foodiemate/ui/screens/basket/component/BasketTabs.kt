package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.ui.screens.basket.model.BasketType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasketTabs(pagerState: PagerState, tabs: MutableList<BasketType>) {
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        contentColor = Color.White,
        indicator = { tabPositions ->
            if (pagerState.currentPage < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }
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