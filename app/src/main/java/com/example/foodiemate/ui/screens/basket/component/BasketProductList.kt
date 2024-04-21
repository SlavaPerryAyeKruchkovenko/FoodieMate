package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketProductList(
    items: List<BasketProduct>,
    editableProduct: MutableState<BasketProduct?>,
    onSelectProduct: (product: BasketProduct, value: Boolean) -> Unit,
    editProductCount: (product: BasketProduct, value: Number, unit: UnitOfMeasure) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), modifier = Modifier
            .fillMaxSize()
            .padding(
                start = CustomTheme.layoutPadding.smallPadding,
                end = CustomTheme.layoutPadding.smallPadding,
            )
    ) {
        items(items.mapIndexed { i: Int, product: BasketProduct ->
            IndexObject(i, product)
        }) { (_, product) ->
            val isEdit = editableProduct.value != null && editableProduct.value == product
            BasketProductCard(product = product, isEdit = isEdit, onEditProduct = { value, unit ->
                editProductCount(product, value, unit)
            }, onEnableEditProduct = {
                editableProduct.value = product
            }, onDisableEditProduct = {
                editableProduct.value = null
            }, onSelect = onSelectProduct
            )
        }
    }
}

@Preview
@Composable
fun BasketProductListPreview() {
    FoodieMateTheme {
        val editableProduct: MutableState<BasketProduct?> = remember {
            mutableStateOf(Mock.mockBasketProduct().first())
        }
        BasketProductList(Mock.mockBasketProduct(), editableProduct, { _, _ -> }, { _, _, _ -> })
    }
}