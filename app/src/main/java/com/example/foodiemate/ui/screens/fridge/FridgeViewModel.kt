package com.example.foodiemate.ui.screens.fridge

import androidx.compose.runtime.toMutableStateList
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
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor() : ViewModel(), EventHandler<FridgeEvent> {
    private val _fridgeViewState: MutableLiveData<FridgeViewState> =
        MutableLiveData(FridgeViewState.Loading)
    val fridgeViewState: LiveData<FridgeViewState> = _fridgeViewState
    private val _searchText = MutableStateFlow("")
    private val searchText = _searchText.asStateFlow()

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

            is FridgeEvent.RemoveProduct -> removeProduct(state, event.product)
            is FridgeEvent.SearchProducts -> searchProducts(event.query, state)
            else -> {}
        }
    }

    private fun reduce(event: FridgeEvent, state: FridgeViewState.NoItems) {
        //Todo add events for noItems page
    }

    @OptIn(FlowPreview::class)
    private fun fetchProducts() {
        viewModelScope.launch {
            delay(2000)
            val isSearching = MutableStateFlow(false)
            val products = MutableStateFlow(Mock.mockFridgeProduct())
            val displayProducts = searchText.debounce(1000L).onEach { isSearching.update { true } }
                .combine(products) { text, items ->
                    if (text.isBlank()) {
                        items
                    } else {
                        delay(1000L)
                        val nameSearched = items.filter {
                            it.product.name.lowercase().contains(text)
                        }
                        val countSearch = items.filter {
                            it.count.toString().contains(text) && !nameSearched.contains(it)
                        }
                        nameSearched + countSearch
                    }
                }.onEach { isSearching.update { false } }.stateIn(
                    viewModelScope, SharingStarted.WhileSubscribed(1000), products.value
                )
            _fridgeViewState.value =
                FridgeViewState.Display(products, displayProducts, isSearching.asStateFlow())
        }
    }

    private fun removeProduct(state: FridgeViewState.Display, product: FridgeProduct) {
        state.items.update { list ->
            list.toMutableStateList().apply {
                removeIf { it.id == product.id }
            }
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

    private fun searchProducts(query: String, state: FridgeViewState.Display) {
        _searchText.value = query.lowercase()
    }
}