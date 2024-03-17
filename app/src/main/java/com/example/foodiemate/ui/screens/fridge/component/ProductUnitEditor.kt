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
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import com.example.foodiemate.utils.NumberUtils.isInt

@Composable
fun ProductUnitEditor(
    value: Number,
    changeValue: (value: Number) -> Unit,
    unit: UnitOfMeasure,
    modifier: Modifier = Modifier
) {
    var productCount by remember {
        mutableStateOf(value.toString())
    }
    val unitMaxValue = when (unit) {
        UnitOfMeasure.Piece -> 1000
        UnitOfMeasure.Liter -> 1000
        UnitOfMeasure.Kilogram -> 1000
        else -> 100000
    }
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
                val parsedDouble = value.toDouble()
                val calculateValue = isInt(parsedDouble, {
                    value.toInt() - 1
                }, { parsedDouble - 1 })
                if (parsedDouble - 1 >= 0) {
                    productCount = calculateValue.toString()
                    changeValue(calculateValue)
                }
            })
        BasicTextField(
            modifier = Modifier.weight(1f),
            value = productCount,
            onValueChange = {
                val decimalCount = if (it.contains(".")) {
                    it.substringAfter(".").length
                } else {
                    1
                }
                val parsedDouble = it.toDoubleOrNull()
                if (parsedDouble != null && parsedDouble < unitMaxValue && decimalCount > 0 && decimalCount < 4) {
                    productCount = it
                    isInt(parsedDouble, {
                        changeValue(parsedDouble.toInt())
                    }, {
                        changeValue(parsedDouble)
                    })
                } else if (it.isEmpty()) {
                    productCount = ""
                    changeValue(0)
                } else if (it.contains(".") && decimalCount == 0) {
                    productCount = it
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
                    val parsedDouble = value.toDouble()
                    val calculateValue = isInt(parsedDouble, {
                        value.toInt() + 1
                    }, { parsedDouble + 1 })
                    if (parsedDouble + 1 < unitMaxValue) {
                        productCount = calculateValue.toString()
                        changeValue(calculateValue)
                    }
                }
                .fillMaxHeight(1f))
    }
}