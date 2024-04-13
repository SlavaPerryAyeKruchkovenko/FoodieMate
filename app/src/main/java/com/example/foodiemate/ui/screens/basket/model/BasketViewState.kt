package com.example.foodiemate.ui.screens.basket.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class BasketViewState {
    data object Loading : BasketViewState()
    data class Display(
        var items: MutableStateFlow<List<FridgeProduct>>,
        val displayItems: StateFlow<List<FridgeProduct>>,
        val isSearch: StateFlow<Boolean>,
        val basketType: StateFlow<BasketType>
    ) : BasketViewState()

    data object NoItems : BasketViewState()
}