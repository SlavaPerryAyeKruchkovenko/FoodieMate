package com.example.foodiemate.ui.screens.basket

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.foodiemate.ui.screens.basket.model.BasketEvent

@Composable
fun BasketScreen(navController: NavHostController, viewModel: BasketViewModel) {
    val viewState = viewModel.basketViewState.observeAsState()
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = BasketEvent.EnterScreen)
    })
}