package com.example.foodiemate.ui.screens.basket

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController

@Composable
fun BasketScreen(navController: NavHostController, viewModel: BasketViewModel) {
    val viewState = viewModel.basketViewState.observeAsState()
}