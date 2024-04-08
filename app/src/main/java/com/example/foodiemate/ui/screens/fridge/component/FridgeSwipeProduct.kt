package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FridgeSwipeProduct(
    modifier: Modifier,
    product: FridgeProduct,
    editableProduct: MutableState<FridgeProduct?>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit,
    onSwipe: () -> Unit = {}
) {
    val state = rememberSwipeToDismissBoxState(confirmValueChange = {
        if (it === SwipeToDismissBoxValue.StartToEnd) {
            onSwipe()
        }
        false
    })
    val isEdit = editableProduct.value != null && editableProduct.value == product
    SwipeToDismissBox(
        modifier = Modifier.then(
            modifier
        ), state = state, backgroundContent = {
            if (state.dismissDirection == SwipeToDismissBoxValue.StartToEnd) {
                FridgeRemoveProduct()
            }
        }, enableDismissFromEndToStart = false
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
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