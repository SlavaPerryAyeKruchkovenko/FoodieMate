package com.example.foodiemate.ui.screens.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
        /*.background(White)*/
    ) {
        /*NavigationAppBar(
            listOf(), stringResource(id = R.string.recipes)
        )*/
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeScreen()
}