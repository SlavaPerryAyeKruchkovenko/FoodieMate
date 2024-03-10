package com.example.foodiemate.ui.screens.fridge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodiemate.base.EventHandler
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.ui.screens.fridge.model.FridgeEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor() : ViewModel(), EventHandler<FridgeEvent> {
    private val _fridgeViewState: MutableLiveData<FridgeViewState> =
        MutableLiveData(FridgeViewState.Loading)
    private val _editableProduct: MutableLiveData<FridgeProduct?> = MutableLiveData(null)
    val fridgeViewState: LiveData<FridgeViewState> = _fridgeViewState
    val editableProduct: LiveData<FridgeProduct?> = _editableProduct
    override fun obtainEvent(event: FridgeEvent) {
        when (val currentState = _fridgeViewState.value) {
            is FridgeViewState.Loading -> reduce(event, currentState)
            is FridgeViewState.Display -> reduce(event, currentState)
            is FridgeViewState.NoItems -> reduce(event, currentState)
            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.Loading) {
        //Todo add events for loading page
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.Display) {
        when (event) {
            is FridgeEvent.EditProductCount -> editProductCount(event.product)
            is FridgeEvent.DisableEditProduct -> editProductCount(null)
            is FridgeEvent.ChangeProductCount -> changeProductCount(event.product, event.value)
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.NoItems) {
        //Todo add events for noItems page
    }

    private fun editProductCount(product: FridgeProduct?) {
        _editableProduct.value = product
    }

    private fun changeProductCount(product: FridgeProduct, value: Number) {
        product.count = value
    }
}