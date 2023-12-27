package com.example.foodiemate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.data.SearchData
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.theme.White

@Composable
fun RecipeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
    ) {
        NavigationAppBar(
            products.map { SearchData(it.id, it.product.name) },
            stringResource(id = R.string.products)
        )
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeScreen()
}