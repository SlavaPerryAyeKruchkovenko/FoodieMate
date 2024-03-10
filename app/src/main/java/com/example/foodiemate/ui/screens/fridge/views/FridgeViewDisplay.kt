package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.component.FridgeProductView
import com.example.foodiemate.ui.theme.component.AddFABLargeIcon
import com.example.foodiemate.ui.theme.component.AddFABMenu
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeViewDisplay(items: List<FridgeProduct>) {
    var isFABMenuOpen by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.primaryBackground)
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
                items(items.mapIndexed { i: Int, product: FridgeProduct ->
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
    FridgeViewDisplay(items = Mock.mockFridgeProduct())
}