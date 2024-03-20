package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.component.FridgeProductList
import com.example.foodiemate.ui.screens.fridge.component.ProductSearchBar
import com.example.foodiemate.ui.theme.component.AddFABLargeIcon
import com.example.foodiemate.ui.theme.component.AddFABMenu
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeViewDisplay(
    items: State<List<FridgeProduct>>,
    navController: NavHostController,
    editProductCount: (product: FridgeProduct, value: Number, unit: UnitOfMeasure) -> Unit,
    onSearch: (query: String) -> Unit,
    isSearching: State<Boolean>
) {
    val editableProduct: MutableState<FridgeProduct?> = remember {
        mutableStateOf(null)
    }
    var isFABMenuOpen by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(CustomTheme.colors.primaryBackground)
    ) {
        val (fab, fabBox) = createRefs()
        val fabPadding = CustomTheme.layoutPadding.addFABPadding
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ProductSearchBar(
                modifier = Modifier, navController, onSearch
            )
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
                FridgeProductList(
                    items = items,
                    editableProduct = editableProduct,
                    editProductCount = editProductCount
                )
            }
        }
        AddFABMenu(
            modifier = Modifier.constrainAs(fabBox) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }, isFABMenuOpen
        )//Menu after click on Floating Action Button
        AddFABLargeIcon(
            Modifier.constrainAs(fab) {
                bottom.linkTo(parent.bottom, margin = fabPadding)
                end.linkTo(parent.end, margin = fabPadding)
            },
            {
                isFABMenuOpen = !isFABMenuOpen
            },
            if (isFABMenuOpen) Icons.Filled.Close else Icons.Filled.Add,
            stringResource(R.string.add_products)
        )// Large floating action button
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
    val navController = rememberNavController()
    FridgeViewDisplay(items = products, navController, { _, _, _ -> }, {}, isSearch)
}