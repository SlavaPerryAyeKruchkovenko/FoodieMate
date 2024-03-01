package com.example.foodiemate.ui.screens.fridge

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.component.FridgeProductView
import com.example.foodiemate.ui.theme.component.AddFABLargeIcon
import com.example.foodiemate.ui.theme.component.AddFABMenu
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val products = Mock.mockFridgeProduct()
    var isFABMenuOpen by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
    ) {
        val (fab, fabBox) = createRefs()
        val fabPadding = CustomTheme.layoutPadding.addFABPadding
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1), modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 12.dp,
                        start = CustomTheme.layoutPadding.smallPadding,
                        end = CustomTheme.layoutPadding.smallPadding
                    )
            ) {
                items(products.mapIndexed { i: Int, product: FridgeProduct ->
                    IndexObject(i, product)
                }) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    ) {
                        FridgeProductView(product = it.value)
                    }
                }
            }

        }
        AddFABMenu(
            modifier = Modifier
                .constrainAs(fabBox) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }, isFABMenuOpen
        )
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
        )

    }

}