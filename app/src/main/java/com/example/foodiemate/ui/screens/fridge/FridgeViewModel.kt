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
import com.example.foodiemate.utils.NumberUtils.isInt
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
            is FridgeEvent.ChangeProductCount -> changeProductCount(
                event.product, event.value, event.unit
            )

            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.NoItems) {
        //Todo add events for noItems page
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            delay(100)
            _fridgeViewState.value = FridgeViewState.Display(Mock.mockFridgeProduct())
        }
    }

    private fun changeProductCount(product: FridgeProduct, value: Number, unit: UnitOfMeasure) {
        var productCount = value.toDouble()
        if (productCount >= 1000) {
            when (unit) {
                UnitOfMeasure.Gram -> {
                    productCount /= 1000
                    product.product.unit = UnitOfMeasure.Kilogram
                }

                UnitOfMeasure.Milliliter -> {
                    productCount /= 1000
                    product.product.unit = UnitOfMeasure.Liter
                }

                else -> {}
            }
        } else if (productCount < 1 && productCount > 0) {
            when (unit) {
                UnitOfMeasure.Kilogram -> {
                    productCount *= 1000
                    product.product.unit = UnitOfMeasure.Gram
                }

                UnitOfMeasure.Liter -> {
                    productCount *= 1000
                    product.product.unit = UnitOfMeasure.Milliliter
                }

                else -> {}
            }
        }
        product.count = isInt(productCount, { productCount.toInt() }, { productCount })
    }
}