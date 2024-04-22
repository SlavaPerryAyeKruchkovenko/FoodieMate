package com.example.foodiemate.ui.screens.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodiemate.base.EventHandler
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.basket.model.BasketEvent
import com.example.foodiemate.ui.screens.basket.model.BasketType
import com.example.foodiemate.ui.screens.basket.model.BasketViewState
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
class BasketViewModel @Inject constructor() : ViewModel(), EventHandler<BasketEvent> {
    private val _basketViewState: MutableLiveData<BasketViewState> =
        MutableLiveData(BasketViewState.Loading)
    val basketViewState: LiveData<BasketViewState> = _basketViewState
    val basketTypes = mutableListOf(BasketType.FamilyBasket, BasketType.PersonalBasket)
    private val _searchText = MutableStateFlow("")
    private val searchText = _searchText.asStateFlow()
    private val _basketType = MutableStateFlow<BasketType>(BasketType.PersonalBasket)
    private val basketType = _basketType.asStateFlow()
    override fun obtainEvent(event: BasketEvent) {
        when (val currentState = _basketViewState.value) {
            is BasketViewState.Loading -> reduce(event, currentState)
            is BasketViewState.Display -> reduce(event, currentState)
            is BasketViewState.NoItems -> reduce(event, currentState)
            else -> {}
        }
    }

    private fun reduce(event: BasketEvent, state: BasketViewState.Loading) {
        when (event) {
            BasketEvent.EnterScreen -> fetchProducts()
            else -> {}
        }
    }

    private fun reduce(event: BasketEvent, state: BasketViewState.Display) {
        when (event) {
            is BasketEvent.ChangeBasketType -> changeBasketType()
            is BasketEvent.SelectProduct -> selectProduct()
            is BasketEvent.SearchProducts -> searchProducts(event.query)
            is BasketEvent.RemoveProductFromBasket -> removeProduct()
            else -> {}
        }
    }

    private fun reduce(event: BasketEvent, state: BasketViewState.NoItems) {
        //Todo add events for noItems page
    }

    @OptIn(FlowPreview::class)
    private fun fetchProducts() {
        viewModelScope.launch {
            delay(2000)
            val isSearching = MutableStateFlow(false)
            val products = MutableStateFlow(Mock.mockBasketProduct())
            val displayProducts = searchText.debounce(1000L).onEach { isSearching.update { true } }
                .combine(products) { text, items ->
                    val typeItems = when (_basketType.value) {
                        BasketType.PersonalBasket -> items.filter { x -> x.family == null }
                        BasketType.FamilyBasket -> items.filter { x -> x.family != null }
                    }
                    if (text.isBlank()) {
                        typeItems
                    } else {
                        delay(1000L)
                        val nameSearched = typeItems.filter {
                            it.product.name.lowercase().contains(text)
                        }
                        val countSearch = typeItems.filter {
                            it.count.toString().contains(text) && !nameSearched.contains(it)
                        }
                        nameSearched + countSearch
                    }
                }.onEach { isSearching.update { false } }.stateIn(
                    viewModelScope, SharingStarted.WhileSubscribed(1000), products.value
                )
            _basketViewState.value = BasketViewState.Display(
                products, displayProducts, isSearching.asStateFlow(), basketType
            )
        }
    }

    private fun changeBasketType() {

    }

    private fun selectProduct() {

    }

    private fun searchProducts(query: String) {
        _searchText.value = query.lowercase()
    }

    private fun removeProduct() {

    }
}