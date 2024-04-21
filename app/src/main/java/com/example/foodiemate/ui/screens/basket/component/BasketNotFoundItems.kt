package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.component.NotFoundBox

@Composable
fun BasketNotFoundItems() {
    NotFoundBox("${stringResource(id = R.string.no_products_in_basket)} ${stringResource(id = R.string.sad_smile)}")
}

@Preview
@Composable
fun BasketNotFoundItemsPreview() {
    BasketNotFoundItems()
}