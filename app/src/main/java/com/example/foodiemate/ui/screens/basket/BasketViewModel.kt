package com.example.foodiemate.ui.screens.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodiemate.base.EventHandler
import com.example.foodiemate.ui.screens.basket.model.BasketEvent
import com.example.foodiemate.ui.screens.basket.model.BasketType
import com.example.foodiemate.ui.screens.basket.model.BasketViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel(), EventHandler<BasketEvent> {
    private val _basketViewState: MutableLiveData<BasketViewState> =
        MutableLiveData(BasketViewState.Loading)
    val basketViewState: LiveData<BasketViewState> = _basketViewState
    val basketTypes = mutableListOf(BasketType.FamilyBasket, BasketType.PersonalBasket)
    override fun obtainEvent(event: BasketEvent) {

    }
}