package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.ui.theme.component.UnitProductView

@Composable
fun BasketProductCard(product: BasketProduct) {
    UnitProductView(product) { scope, productCount, unit ->

    }
}

@Preview
@Composable
fun BasketProductCardPreview() {

}