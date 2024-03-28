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
import androidx.compose.ui.unit.dp
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
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
            .padding(top = 12.dp)
    ) {
        items(items.value.mapIndexed { i: Int, product: FridgeProduct ->
            IndexObject(i, product)
        }) { (index, product) ->
            val state = rememberSwipeToDismissBoxState()
            val isEdit = editableProduct.value != null && editableProduct.value == product
            SwipeToDismissBox(
                modifier = Modifier.then(
                    if (index == items.value.size - 1) {
                        Modifier.padding(
                            top = 8.dp,
                            bottom = lastProductPadding,
                        )
                    } else {
                        Modifier.padding(top = 8.dp)
                    }
                ), state = state, backgroundContent = {
                    val isDelete = state.dismissDirection == SwipeToDismissBoxValue.StartToEnd
                    if (isDelete) {
                        FridgeRemoveProduct()
                    }
                }, enableDismissFromEndToStart = false
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = CustomTheme.layoutPadding.smallPadding,
                            end = CustomTheme.layoutPadding.smallPadding,
                        )
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