package com.example.foodiemate.ui.fridge

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.product.FridgeProductView
import com.example.foodiemate.ui.theme.White

@Composable
fun FridgeScreen() {
    val products = Mock.mockFridgeProduct()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp),
        containerColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavigationAppBar()
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp)
            ) {
                items(
                    products
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(8.dp)

                    ) {
                        FridgeProductView(product = it)
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