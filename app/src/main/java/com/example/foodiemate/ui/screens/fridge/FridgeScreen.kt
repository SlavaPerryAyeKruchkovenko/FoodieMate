package com.example.foodiemate.ui.screens.fridge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.foodiemate.R
import com.example.foodiemate.ui.screens.fridge.component.ProductSearchBar
import com.example.foodiemate.ui.screens.fridge.model.FridgeEvent
import com.example.foodiemate.ui.screens.fridge.model.FridgeViewState
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewDisplay
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewLoading
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewNoItems
import com.example.foodiemate.ui.theme.component.AddFABLargeIcon
import com.example.foodiemate.ui.theme.component.AddFABMenu
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val viewState = viewModel.fridgeViewState.observeAsState()
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
                modifier = Modifier, navController
            ) {
                viewModel.obtainEvent(FridgeEvent.SearchProducts(it))
            }
            when (val state = viewState.value) {
                is FridgeViewState.Loading -> FridgeViewLoading()
                is FridgeViewState.Display -> FridgeViewDisplay(
                    items = state.displayItems.collectAsState(),
                    editProductCount = { product, value, unit ->
                        viewModel.obtainEvent(FridgeEvent.ChangeProductCount(product, value, unit))
                    },
                    isSearching = state.isSearch.collectAsState(),
                    removeProduct = {
                        viewModel.obtainEvent(FridgeEvent.RemoveProduct(it))
                    }
                )

                is FridgeViewState.NoItems -> FridgeViewNoItems()
                else -> throw NotImplementedError("Unexpected daily state")
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
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = FridgeEvent.EnterScreen)
    })
}