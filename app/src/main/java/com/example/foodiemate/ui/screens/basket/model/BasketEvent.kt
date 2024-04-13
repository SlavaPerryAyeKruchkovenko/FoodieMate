package com.example.foodiemate.ui.screens.basket.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct

sealed class BasketEvent {
    data object EnterScreen : BasketEvent()
    data class SearchProducts(
        val query: String
    ) : BasketEvent()

    data class SelectProduct(val product: FridgeProduct) : BasketEvent()
    data class ChangeBasketType(val type: BasketType) : BasketEvent()
    data object RemoveProductFromBasket : BasketEvent()
}