package com.example.foodiemate.ui.screens.fridge

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewDisplay
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewLoading

@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val viewState = viewModel.fridgeViewState.observeAsState()
    when (val state = viewState.value) {
        is FridgeViewState.Loading -> FridgeViewLoading()
        is FridgeViewState.Display -> FridgeViewDisplay(items = state.items)
        else -> {
            Text("Error")
        }
    }
}