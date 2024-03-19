package com.example.foodiemate.ui.screens.fridge.model

import androidx.lifecycle.MutableLiveData
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct

sealed class FridgeViewState {
    object Loading : FridgeViewState()
    data class Display(
        val items: List<FridgeProduct>,
        var displayItems: MutableLiveData<List<FridgeProduct>>,
    ) : FridgeViewState()

    object NoItems : FridgeViewState()
}