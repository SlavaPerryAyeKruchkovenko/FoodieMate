package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.component.NotFoundBox

@Composable
fun FridgeViewNoItems() {
    NotFoundBox("${stringResource(id = R.string.fridge_is_empty)} ${stringResource(id = R.string.sad_smile)}")
}

@Preview
@Composable
fun FridgeViewNoItemsPreview() {
    FridgeViewNoItems()
}