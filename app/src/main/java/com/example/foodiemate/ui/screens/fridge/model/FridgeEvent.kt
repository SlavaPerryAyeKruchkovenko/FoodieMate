package com.example.foodiemate.ui.screens.fridge.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure

sealed class FridgeEvent {
    data object EnterScreen : FridgeEvent()
    data class SearchProducts(
        val query: String
    ) : FridgeEvent()

    data class ChangeProductCount(
        val product: FridgeProduct, val value: Number, val unit: UnitOfMeasure
    ) : FridgeEvent()

    data class RemoveProduct(val product: FridgeProduct) : FridgeEvent()
}