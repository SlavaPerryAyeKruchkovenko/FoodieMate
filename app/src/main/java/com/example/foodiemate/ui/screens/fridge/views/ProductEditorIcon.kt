package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
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
            .border(
                1.dp,
                tint,
                RoundedCornerShape(CustomTheme.layoutSize.mediumIconSize)
            )
            .padding(CustomTheme.layoutPadding.mediumIconPadding)
            .size(CustomTheme.layoutSize.mediumIconSize)
            .then(modifier),
        imageVector = imageVector,
        contentDescription = stringResource(description),
        tint = tint
    )
}
@Preview
@Composable
fun ProductEditorIconPreview(){
    ProductEditorIcon(Icons.Filled.Add, R.string.remove_product, CustomTheme.colors.removeProduct)
}