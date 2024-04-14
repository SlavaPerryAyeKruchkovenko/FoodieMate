package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R
import kotlinx.coroutines.delay

@Composable
fun Loader(delay: Long, rotateValue: Float, size: Dp) {
    var rotationValue by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            rotationValue += rotateValue
            delay(delay)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(size)
                .rotate(rotationValue),
            painter = painterResource(id = R.drawable.loader),
            contentDescription = stringResource(R.string.loading),
        )
    }
}

@Preview
@Composable
fun PreviewLoader() {
    Loader(50, 5f, 100.dp)
}