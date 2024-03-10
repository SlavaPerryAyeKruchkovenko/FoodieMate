package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductEditorIcon(
    imageVector: ImageVector,
    description: Int,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = Modifier
            .size(CustomTheme.layoutSize.mediumIconSize)
            .background(
                CustomTheme.colors.editorIconBackground,
                RoundedCornerShape(CustomTheme.shapeRadius.editorIconCorner)
            )
            .then(modifier),
        imageVector = imageVector,
        contentDescription = stringResource(description),
        tint = tint
    )
}

@Preview
@Composable
fun ProductEditorIconPreview() {
    ProductEditorIcon(Icons.Filled.Add, R.string.remove_product, CustomTheme.colors.removeProduct)
}