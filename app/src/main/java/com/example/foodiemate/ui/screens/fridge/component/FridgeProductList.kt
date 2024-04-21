package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.component.ConfirmDialog
import com.example.foodiemate.ui.theme.customTheme.CustomModifier.paddingForCard
import com.example.foodiemate.ui.theme.customTheme.CustomTheme


@Composable
fun FridgeProductList(
    items: List<FridgeProduct>,
    editableProduct: MutableState<FridgeProduct?>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit,
    removeProduct: (product: FridgeProduct) -> Unit
) {
    val lastItemMargin =
        CustomTheme.layoutSize.addFABSize + CustomTheme.layoutPadding.addFABPadding * 2
    val firstItemMargin = CustomTheme.layoutPadding.firstProductMarginTop
    val itemMargin = CustomTheme.layoutPadding.productCardMargin
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), modifier = Modifier
            .fillMaxSize()
            .padding(
                start = CustomTheme.layoutPadding.smallPadding,
                end = CustomTheme.layoutPadding.smallPadding,
            )
    ) {
        items(items.mapIndexed { i: Int, product: FridgeProduct ->
            IndexObject(i, product)
        }) { (index, product) ->
            var openAlertDialog by remember { mutableStateOf(false) }
            when {
                openAlertDialog -> {
                    ConfirmDialog(
                        onDismissRequest = { openAlertDialog = false },
                        onConfirmation = {
                            removeProduct(product)
                            openAlertDialog = false
                        },
                        dialogTitle = stringResource(id = R.string.remove_product),
                        dialogText = stringResource(id = R.string.remove_fridge_product),
                        icon = Icons.Filled.Warning,
                    )
                }
            }
            FridgeSwipeProduct(modifier = Modifier.paddingForCard(
                index, items.size, firstItemMargin, lastItemMargin, itemMargin
            ),
                product = product,
                editableProduct = editableProduct,
                editProductCount = editProductCount,
                onSwipe = {
                    openAlertDialog = true
                })
        }
    }
}

@Preview
@Composable
fun FridgeProductListPreview() {
    val editableProduct: MutableState<FridgeProduct?> = remember {
        mutableStateOf(Mock.mockFridgeProduct().first())
    }
    FridgeProductList(items = Mock.mockFridgeProduct(), editableProduct, { _, _, _ -> }, { _ -> })
}