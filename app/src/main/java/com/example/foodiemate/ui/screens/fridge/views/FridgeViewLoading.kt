package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import kotlinx.coroutines.delay

@Composable
fun FridgeViewLoading() {
    var rotationValue by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            rotationValue += 5f
            delay(50)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.primaryBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(CustomTheme.layoutSize.loaderSize)
                .rotate(rotationValue),
            painter = painterResource(id = R.drawable.loader),
            contentDescription = stringResource(R.string.loading),
        )
    }
}

@Preview
@Composable
fun FridgeViewLoadingPreview() {
    FridgeViewLoading()
}