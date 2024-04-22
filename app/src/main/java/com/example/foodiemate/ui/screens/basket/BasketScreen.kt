package com.example.foodiemate.ui.screens.basket

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.foodiemate.R
import com.example.foodiemate.ui.screens.basket.component.BasketTabs
import com.example.foodiemate.ui.screens.basket.model.BasketEvent
import com.example.foodiemate.ui.screens.basket.model.BasketViewState
import com.example.foodiemate.ui.screens.basket.views.BasketViewDisplay
import com.example.foodiemate.ui.screens.basket.views.BasketViewLoading
import com.example.foodiemate.ui.screens.basket.views.BasketViewNoItems
import com.example.foodiemate.ui.theme.component.AddFABLargeIcon
import com.example.foodiemate.ui.theme.component.AppSearchBar
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasketScreen(navController: NavHostController, viewModel: BasketViewModel) {
    val viewState = viewModel.basketViewState.observeAsState()
    var isFABMenuOpen by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(CustomTheme.colors.primaryBackground)
    ) {
        val (fab) = createRefs()
        val fabPadding = CustomTheme.layoutPadding.addFABPadding
        Column(modifier = Modifier.fillMaxSize()) {
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
                    is BasketViewState.Display -> BasketViewDisplay(items = state.displayItems.collectAsState().value,
                        isSearching = state.isSearch.collectAsState().value,
                        onSelectProduct = { product, value ->
                            viewModel.obtainEvent(BasketEvent.SelectProduct(product, value))
                        },
                        editProductCount = { _, _, _ -> })

                    else -> throw NotImplementedError("Unexpected daily state")
                }
            }
        }
        AddFABLargeIcon(
            modifier = Modifier.constrainAs(fab) {
                bottom.linkTo(parent.bottom, margin = fabPadding)
                end.linkTo(parent.end, margin = fabPadding)
            },
            onClick = { isFABMenuOpen = !isFABMenuOpen },
            painter = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_product_to_basket)
        )
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = BasketEvent.EnterScreen)
    })
}