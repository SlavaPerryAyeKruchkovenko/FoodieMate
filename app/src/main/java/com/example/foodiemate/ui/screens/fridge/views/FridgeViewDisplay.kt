package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.component.FridgeNotFoundItems
import com.example.foodiemate.ui.screens.fridge.component.FridgeProductList
import com.example.foodiemate.ui.theme.component.SearchIndicator
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeViewDisplay(
    items: List<FridgeProduct>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit,
    isSearching: Boolean,
    removeProduct: (product: FridgeProduct) -> Unit
) {
    val editableProduct: MutableState<FridgeProduct?> = remember {
        mutableStateOf(null)
    }
    if (isSearching) {
        SearchIndicator(
            color = CustomTheme.colors.primaryText,
            size = CustomTheme.layoutSize.searchLoaderSize
        )
    } else {
        if (items.isEmpty()) {
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
    FridgeViewDisplay(items = Mock.mockFridgeProduct(), { _, _, _ -> }, false, {})
}