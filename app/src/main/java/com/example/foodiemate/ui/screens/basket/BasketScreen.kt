package com.example.foodiemate.ui.screens.basket

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.foodiemate.ui.screens.basket.component.BasketTabs
import com.example.foodiemate.ui.screens.basket.model.BasketEvent
import com.example.foodiemate.ui.screens.basket.model.BasketViewState
import com.example.foodiemate.ui.screens.basket.views.BasketViewLoading
import com.example.foodiemate.ui.screens.basket.views.BasketViewNoItems
import com.example.foodiemate.ui.theme.component.AppSearchBar
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasketScreen(navController: NavHostController, viewModel: BasketViewModel) {
    val viewState = viewModel.basketViewState.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.primaryBackground)
    ) {
        val pagerState = rememberPagerState(pageCount = {
            viewModel.basketTypes.size
        })
        AppSearchBar(modifier = Modifier, navController) {
            viewModel.obtainEvent(BasketEvent.SearchProducts(it))
        }
        BasketTabs(pagerState, viewModel.basketTypes)
        HorizontalPager(state = pagerState) {
            when (val state = viewState.value) {
                is BasketViewState.Loading -> BasketViewLoading()
                is BasketViewState.NoItems -> BasketViewNoItems()
                else -> throw NotImplementedError("Unexpected daily state")
            }
        }
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = BasketEvent.EnterScreen)
    })
}