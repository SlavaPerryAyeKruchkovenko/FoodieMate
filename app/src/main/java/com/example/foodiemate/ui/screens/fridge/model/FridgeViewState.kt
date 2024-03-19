package com.example.foodiemate.ui.screens.fridge.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import kotlinx.coroutines.flow.StateFlow

sealed class FridgeViewState {
    object Loading : FridgeViewState()
    data class Display(
        val items: List<FridgeProduct>,
        var displayItems: StateFlow<List<FridgeProduct>>,
    ) : FridgeViewState()

    object NoItems : FridgeViewState()
}