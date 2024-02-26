package com.example.foodiemate.ui.screens.fridge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.fridge.views.FridgeProductView
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val products = Mock.mockFridgeProduct()
    Column(
        modifier = Modifier
            .fillMaxSize()
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
}