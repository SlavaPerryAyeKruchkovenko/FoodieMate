package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductIcon(
    imageVector: ImageVector,
    description: Int,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = Modifier
            .border(
                1.dp,
                tint,
                RoundedCornerShape(CustomTheme.shapeRadius.iconBorderShape)
            )
            .padding(CustomTheme.layoutPadding.smallIconPadding)
            .size(CustomTheme.layoutSize.smallIconSize)
            .then(modifier),
        imageVector = imageVector,
        contentDescription = stringResource(id = description),
        tint = tint
    )
}

@Preview
@Composable
fun ProductIconPreview() {
    ProductIcon(Icons.Filled.Close, R.string.remove_product, CustomTheme.colors.removeProduct)
}