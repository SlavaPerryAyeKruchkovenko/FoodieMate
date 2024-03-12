package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductUnitEditor(
    value: Number, changeValue: (value: Number) -> Unit, modifier: Modifier = Modifier
) {
    var unitValue by remember {
        mutableStateOf(value.toString())
    }
    val maxValue = 100000
    Row(
        modifier = Modifier
            .then(modifier)
            .background(
                CustomTheme.colors.editorBackground,
                RoundedCornerShape(CustomTheme.shapeRadius.editorCorner)
            )
            .padding(CustomTheme.layoutPadding.productEditorPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductEditorIcon(imageVector = ImageVector.vectorResource(R.drawable.minus),
            description = R.string.reduce,
            tint = CustomTheme.colors.reduceColor,
            modifier = Modifier.clickable {
                if (value is Double) {
                    val calculateValue = value.toDouble() - 1
                    if (calculateValue >= 0) {
                        unitValue = (calculateValue).toString()
                        changeValue(calculateValue)
                    }
                } else {
                    val calculateValue = value.toInt() - 1
                    if (calculateValue >= 0) {
                        unitValue = (calculateValue).toString()
                        changeValue(calculateValue)
                    }
                }
            })
        BasicTextField(
            modifier = Modifier.weight(1f),
            value = unitValue,
            onValueChange = {
                val decimalCount = if (it.contains(".")) {
                    it.substringAfter(".").length
                } else {
                    1
                }
                val parsedDouble = it.toDoubleOrNull()
                if (parsedDouble != null && parsedDouble < maxValue && decimalCount > 0 && decimalCount < 4) {
                    unitValue = it
                    if (parsedDouble % 1 == 0.0) {
                        changeValue(parsedDouble.toInt())
                    } else {
                        changeValue(parsedDouble)
                    }
                } else if (it.isEmpty()) {
                    unitValue = ""
                    changeValue(0)
                } else if (it.contains(".") && decimalCount == 0) {
                    unitValue = it
                }
            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = CustomTheme.colors.primaryText,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        )
        ProductEditorIcon(imageVector = Icons.Filled.Add,
            description = R.string.add,
            tint = CustomTheme.colors.addColor,
            modifier = Modifier
                .clickable {
                    if (value is Double) {
                        val calculateValue = value.toDouble() + 1
                        if (calculateValue < maxValue) {
                            unitValue = (calculateValue).toString()
                            changeValue(calculateValue)
                        }
                        unitValue = (calculateValue).toString()
                        changeValue(calculateValue)
                    } else {
                        val calculateValue = value.toInt() + 1
                        if (calculateValue < maxValue) {
                            unitValue = (calculateValue).toString()
                            changeValue(calculateValue)
                        }
                    }
                }
                .fillMaxHeight(1f))
    }
}