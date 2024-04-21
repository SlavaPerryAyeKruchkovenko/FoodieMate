package com.example.foodiemate.ui.screens.basket.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.basket.component.BasketNotFoundItems
import com.example.foodiemate.ui.screens.basket.component.BasketProductList
import com.example.foodiemate.ui.theme.component.SearchIndicator
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketViewDisplay(
    items: List<BasketProduct>,
    isSearching: Boolean,
    selectProduct: (product: BasketProduct) -> Unit,
    editProductCount: (product: BasketProduct, value: Number, unit: UnitOfMeasure) -> Unit,
) {
    val editableProduct: MutableState<BasketProduct?> = remember {
        mutableStateOf(null)
    }
    if (isSearching) {
        SearchIndicator(
            color = CustomTheme.colors.primaryText, size = CustomTheme.layoutSize.searchLoaderSize
        )
    } else {
        if (items.isEmpty()) {
            BasketNotFoundItems()
        } else {
            BasketProductList(
                items = items,
                editableProduct = editableProduct,
                onSelectProduct = selectProduct,
                editProductCount = editProductCount
            )
        }
    }
}

@Preview
@Composable
fun BasketViewDisplayPreview() {
    BasketViewDisplay(Mock.mockBasketProduct(), false, { _ -> }, { _, _, _ -> })
}