package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeProductList(
    items: State<List<FridgeProduct>>,
    editableProduct: MutableState<FridgeProduct?>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit
) {
    val lastProductPadding =
        CustomTheme.layoutSize.addFABSize + CustomTheme.layoutPadding.addFABPadding * 2
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 12.dp,
                start = CustomTheme.layoutPadding.smallPadding,
                end = CustomTheme.layoutPadding.smallPadding,
            )
    ) {
        items(items.value.mapIndexed { i: Int, product: FridgeProduct ->
            IndexObject(i, product)
        }) { (index, product) ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .then(
                        if (index == items.value.size - 1) {
                            Modifier.padding(top = 8.dp, bottom = lastProductPadding)
                        } else {
                            Modifier.padding(top = 8.dp)
                        }
                    )
            ) {
                val isEdit = editableProduct.value != null && editableProduct.value == product
                FridgeProductView(product = product, isEdit = isEdit, onEnableEditProduct = {
                    editableProduct.value = product
                }, onEditProduct = { value, unit ->
                    editProductCount(product, value, unit)
                }, onDisableEditProduct = {
                    editableProduct.value = null
                })
            }
        }
    }
}