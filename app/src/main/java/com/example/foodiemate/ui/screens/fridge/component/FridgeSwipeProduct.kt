package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock

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

@Preview
@Composable
fun FridgeSwipeProductPreview() {
    val editableProduct: MutableState<FridgeProduct?> = remember {
        mutableStateOf(null)
    }
    FridgeSwipeProduct(
        modifier = Modifier.padding(0.dp),
        product = Mock.mockFridgeProduct()[0],
        editableProduct = editableProduct,
        editProductCount = { _, _, _ -> },
        onSwipe = {}
    )
}