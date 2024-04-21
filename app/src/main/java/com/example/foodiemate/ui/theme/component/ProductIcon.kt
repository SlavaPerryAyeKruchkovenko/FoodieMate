package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R

@Composable
fun ProductIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector, description: Int, tint: Color,
    size: Dp,
) {
    Icon(
        modifier = Modifier
            .size(size)
            .then(modifier),
        imageVector = imageVector,
        contentDescription = stringResource(id = description),
        tint = tint
    )
}

@Preview
@Composable
fun ProductIconPreview() {
    ProductIcon(
        Modifier, Icons.TwoTone.Check, R.string.accept, Color.Green, 20.dp
    )
}