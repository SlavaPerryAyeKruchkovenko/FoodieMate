package com.example.foodiemate.ui.screens.basket.model

import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class BasketViewState {
    data object Loading : BasketViewState()
    data class Display(
        var items: MutableStateFlow<List<BasketProduct>>,
        val displayItems: StateFlow<List<BasketProduct>>,
        val isSearch: StateFlow<Boolean>,
        val basketType: StateFlow<BasketType>
    ) : BasketViewState()

    data object NoItems : BasketViewState()
}