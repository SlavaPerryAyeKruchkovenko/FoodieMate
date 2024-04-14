package com.example.foodiemate.ui.screens.basket.model

import com.example.foodiemate.R

sealed class BasketType(val icon: Int, val title: Int) {
    data object FamilyBasket : BasketType(R.drawable.family, R.string.family_basket)
    data object PersonalBasket : BasketType(R.drawable.personal, R.string.personal_basket)
}