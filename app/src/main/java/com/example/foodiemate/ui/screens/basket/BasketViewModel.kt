package com.example.foodiemate.ui.screens.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodiemate.base.EventHandler
import com.example.foodiemate.ui.screens.basket.model.BasketEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel(), EventHandler<BasketEvent> {
    private val _basketViewState: MutableLiveData<FridgeViewState> =
        MutableLiveData(FridgeViewState.Loading)
    val basketViewState: LiveData<FridgeViewState> = _basketViewState
    override fun obtainEvent(event: BasketEvent) {
        TODO("Not yet implemented")
    }
}