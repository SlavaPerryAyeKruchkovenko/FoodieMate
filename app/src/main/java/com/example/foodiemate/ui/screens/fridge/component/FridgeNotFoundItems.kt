package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.screens.fridge.views.FridgeViewNoItems
import com.example.foodiemate.ui.theme.component.NotFoundBox

@Composable
fun FridgeNotFoundItems() {
    NotFoundBox("${stringResource(id = R.string.products_not_found)} ${stringResource(id = R.string.sad_smile)}")
}

@Preview
@Composable
fun FridgeNotFoundItemsPreview() {
    FridgeViewNoItems()
}