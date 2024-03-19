package com.example.foodiemate.ui.screens.fridge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.foodiemate.ui.screens.fridge.model.FridgeEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewDisplay
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewLoading

@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val viewState = viewModel.fridgeViewState.observeAsState()
    when (val state = viewState.value) {
        is FridgeViewState.Loading -> FridgeViewLoading()
        is FridgeViewState.Display -> FridgeViewDisplay(
            items = state.displayItems.observeAsState().value ?: listOf(),
            navController = navController,
            editProductCount = { product, value, unit ->
                viewModel.obtainEvent(FridgeEvent.ChangeProductCount(product, value, unit))
            },
            onSearch = {
                viewModel.obtainEvent(FridgeEvent.SearchProducts(it))
            }
        )

        else -> throw NotImplementedError("Unexpected daily state")
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = FridgeEvent.EnterScreen)
    })
}