package com.example.foodiemate.ui.screens.fridge.component

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import com.example.foodiemate.utils.ProductUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FridgeProductList(
    items: State<List<FridgeProduct>>,
    editableProduct: MutableState<FridgeProduct?>,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit
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
        items(items.value.mapIndexed { i: Int, product: FridgeProduct ->
            IndexObject(i, product)
        }) { (index, product) ->
            val state = rememberSwipeToDismissBoxState(confirmValueChange = {
                //ToDo remove product
                false
            })
            val isEdit = editableProduct.value != null && editableProduct.value == product
            SwipeToDismissBox(
                modifier = Modifier.then(
                    ProductUtils.getModifierWithPaddingForCard(
                        index, items.value.size, firstItemMargin, lastItemMargin, itemMargin
                    )
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
    }
}