package com.example.foodiemate.ui.screens.fridge

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.foodiemate.ui.screens.fridge.model.FridgeEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewDisplay
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewLoading
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewNoItems

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val viewState = viewModel.fridgeViewState.observeAsState()
    when (val state = viewState.value) {
        is FridgeViewState.Loading -> FridgeViewLoading()
        is FridgeViewState.Display -> FridgeViewDisplay(
            items = state.displayItems.collectAsState(),
            navController = navController,
            editProductCount = { product, value, unit ->
                viewModel.obtainEvent(FridgeEvent.ChangeProductCount(product, value, unit))
            },
            onSearch = {
                viewModel.obtainEvent(FridgeEvent.SearchProducts(it))
            },
            isSearching = state.isSearch.collectAsState(),
            removeProduct = {
                viewModel.obtainEvent(FridgeEvent.RemoveProduct(it))
            }
        )

        is FridgeViewState.NoItems -> FridgeViewNoItems()
        else -> throw NotImplementedError("Unexpected daily state")
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = FridgeEvent.EnterScreen)
    })
}