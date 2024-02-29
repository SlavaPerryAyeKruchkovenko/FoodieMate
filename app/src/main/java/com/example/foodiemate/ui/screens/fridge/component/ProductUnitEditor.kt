package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductUnitEditor(
    value: Number,
    changeValue: (value: Number) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProductEditorIcon(
            imageVector = ImageVector.vectorResource(R.drawable.minus),
            description = R.string.reduce,
            tint = CustomTheme.colors.reduceColor,
            modifier = Modifier.clickable {
                changeValue(value.toFloat() - 1)
            }
        )
        Text(
            text = value.toString(),
            style = TextStyle(
                color = CustomTheme.colors.secondaryText,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 20.sp,
            ),
        )
        ProductEditorIcon(
            imageVector = Icons.Filled.Add,
            description = R.string.add,
            tint = CustomTheme.colors.addColor,
            modifier = Modifier.clickable {
                changeValue(value.toFloat() + 1)
            }
        )
    }
}