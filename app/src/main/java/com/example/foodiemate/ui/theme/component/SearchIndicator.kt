package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SearchIndicator(color: Color, size: Dp) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            color = color,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size)
        )
    }
}

@Preview
@Composable
fun SearchIndicatorPreview() {
    SearchIndicator(color = Color.Red, size = 60.dp)
}