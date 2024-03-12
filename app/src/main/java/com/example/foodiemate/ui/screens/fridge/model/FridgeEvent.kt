package com.example.foodiemate.ui.screens.fridge.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct

sealed class FridgeEvent {
    data class EditProductCount(val product: FridgeProduct) : FridgeEvent()
    data object DisableEditProduct : FridgeEvent()
    data object EnterScreen : FridgeEvent()
    data class ChangeProductCount(val product: FridgeProduct, val value: Number) : FridgeEvent()
}