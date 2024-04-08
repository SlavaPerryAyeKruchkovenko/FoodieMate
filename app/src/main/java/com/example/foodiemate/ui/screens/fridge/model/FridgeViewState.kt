package com.example.foodiemate.ui.screens.fridge.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class FridgeViewState {
    data object Loading : FridgeViewState()
    data class Display(
        var items: MutableStateFlow<List<FridgeProduct>>,
        val displayItems: StateFlow<List<FridgeProduct>>,
        val isSearch: StateFlow<Boolean>
    ) : FridgeViewState()

    data object NoItems : FridgeViewState()
}