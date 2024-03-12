package com.example.foodiemate.ui.screens.fridge.model

import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct

sealed class FridgeEvent {
    data object EnterScreen : FridgeEvent()
    data class ChangeProductCount(val product: FridgeProduct, val value: Number) : FridgeEvent()
}