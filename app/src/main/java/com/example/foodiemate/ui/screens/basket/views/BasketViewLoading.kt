package com.example.foodiemate.ui.screens.basket.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.ui.theme.component.Loader
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketViewLoading() {
    Loader(50, 5f, CustomTheme.layoutSize.loaderSize)
}

@Preview
@Composable
fun BasketViewLoadingPreview() {
    BasketViewLoading()
}