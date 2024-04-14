package com.example.foodiemate.ui.screens.basket.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.component.NotFoundBox

@Composable
fun BasketViewNoItems() {
    NotFoundBox("${stringResource(id = R.string.basket_is_empty)} ${stringResource(id = R.string.sad_smile)}")
}

@Preview
@Composable
fun BasketViewNoItemsPreview() {
    BasketViewNoItems()
}