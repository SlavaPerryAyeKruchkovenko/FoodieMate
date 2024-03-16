package com.example.foodiemate.ui.screens.fridge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodiemate.base.EventHandler
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.model.FridgeEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor() : ViewModel(), EventHandler<FridgeEvent> {
    private val _fridgeViewState: MutableLiveData<FridgeViewState> =
        MutableLiveData(FridgeViewState.Loading)
    val fridgeViewState: LiveData<FridgeViewState> = _fridgeViewState
    override fun obtainEvent(event: FridgeEvent) {
        when (val currentState = _fridgeViewState.value) {
            is FridgeViewState.Loading -> reduce(event, currentState)
            is FridgeViewState.Display -> reduce(event, currentState)
            is FridgeViewState.NoItems -> reduce(event, currentState)
            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.Loading) {
        when (event) {
            FridgeEvent.EnterScreen -> fetchProducts()
            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.Display) {
        when (event) {
            is FridgeEvent.ChangeProductCount -> changeProductCount(event.product, event.value)
            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.NoItems) {
        //Todo add events for noItems page
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            delay(2000)
            _fridgeViewState.value = FridgeViewState.Display(Mock.mockFridgeProduct())
        }
    }

    private fun changeProductCount(product: FridgeProduct, value: Number) {
        val productCount = value.toDouble()
        if (productCount >= 1000) {
            when (product.product.unit) {
                UnitOfMeasure.Gram -> {
                    product.product.unit = UnitOfMeasure.Kilogram
                }

                UnitOfMeasure.Milliliter -> {
                    product.product.unit = UnitOfMeasure.Liter
                }

                else -> {}
            }
        } else if (productCount < 1 && productCount > 0) {
            when (product.product.unit) {
                UnitOfMeasure.Kilogram -> {
                    product.product.unit = UnitOfMeasure.Gram
                }

                UnitOfMeasure.Liter -> {
                    product.product.unit = UnitOfMeasure.Milliliter
                }

                else -> {}
            }
        }
        product.count = value
    }
}