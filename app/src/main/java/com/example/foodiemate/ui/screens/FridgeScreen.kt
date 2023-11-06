package com.example.foodiemate.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R
import com.example.foodiemate.data.FridgeProduct
import com.example.foodiemate.data.IndexObject
import com.example.foodiemate.data.SearchData
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.product.FridgeProductView
import com.example.foodiemate.ui.theme.White

@Composable
fun FridgeScreen() {
    val products = Mock.mockFridgeProduct()
    Scaffold(
        modifier = Modifier.fillMaxWidth(), containerColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavigationAppBar(
                products.map { SearchData(it.id, it.product.name) },
                stringResource(id = R.string.products)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 80.dp, start = 16.dp, end = 16.dp)
            ) {
                items(products.mapIndexed { i: Int, product: FridgeProduct ->
                    IndexObject(i, product)
                }) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = if (it.index % 2 == 0) Modifier.padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 8.dp
                        ) else Modifier.padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            start = 8.dp
                        )

                    ) {
                        FridgeProductView(product = it.value)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    FridgeScreen()
}