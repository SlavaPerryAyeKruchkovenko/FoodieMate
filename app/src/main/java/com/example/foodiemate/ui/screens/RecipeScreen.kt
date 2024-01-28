package com.example.foodiemate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.theme.White

@Composable
fun RecipeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        NavigationAppBar(
            listOf(), stringResource(id = R.string.recipes)
        )
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeScreen()
}