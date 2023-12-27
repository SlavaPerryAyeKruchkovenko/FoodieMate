package com.example.foodiemate.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.data.models.FridgeProduct
import com.example.foodiemate.data.IndexObject
import com.example.foodiemate.data.SearchData
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.product.FridgeProductView
import com.example.foodiemate.ui.theme.Blue300
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White

@SuppressLint("UnnecessaryComposedModifier")
@Composable
fun FridgeScreen() {
    val products = Mock.mockFridgeProduct()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
    ) {
        val (content, fab) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(content) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
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
                        modifier = Modifier
                            .fillMaxSize()
                            .composed {
                                if (it.index % 2 == 0) Modifier.padding(
                                    top = 8.dp,
                                    bottom = 8.dp,
                                    end = 8.dp
                                ) else Modifier.padding(
                                    top = 8.dp,
                                    bottom = 8.dp,
                                    start = 8.dp
                                )
                            }
                    ) {
                        FridgeProductView(product = it.value)
                    }
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .size(64.dp)
                .constrainAs(fab) {
                    bottom.linkTo(parent.bottom, margin = 104.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                },
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            containerColor = Blue300,
            shape = RoundedCornerShape(50),
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, "", tint = Blue700, modifier = Modifier.size(24.dp))
        }
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    FridgeScreen()
}