package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.component.FridgeNotFoundItems
import com.example.foodiemate.ui.screens.fridge.component.FridgeProductList
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeViewDisplay(
    items: State<List<FridgeProduct>>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit,
    isSearching: State<Boolean>,
    removeProduct: (product: FridgeProduct) -> Unit
) {
    val editableProduct: MutableState<FridgeProduct?> = remember {
        mutableStateOf(null)
    }
    if (isSearching.value) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                color = CustomTheme.colors.primaryText,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(CustomTheme.layoutSize.searchLoaderSize)
            )
        }
    } else {
        if (items.value.isEmpty()) {
            FridgeNotFoundItems()
        } else {
            FridgeProductList(
                items = items,
                editableProduct = editableProduct,
                editProductCount = editProductCount,
                removeProduct
            )
        }
    }
}

@Preview
@Composable
fun FridgeViewDisplayPreview() {
    val products = remember {
        mutableStateOf(Mock.mockFridgeProduct())
    }
    val isSearch = remember {
        mutableStateOf(false)
    }
    FridgeViewDisplay(items = products, { _, _, _ -> }, isSearch, {})
}