package com.example.foodiemate.ui.screens.fridge.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock.mockFridgeProduct
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductUnit(product: FridgeProduct,modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.then(modifier),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            modifier = Modifier
                .heightIn(0.dp, 20.dp),
            text = product.count.toString() + " " + stringResource(
                id = product.product.unit.acronym
            ),
            style = TextStyle(
                fontSize = 18.sp,
                color = CustomTheme.colors.primaryText,
                lineHeight = 20.sp
            ),
        )
    }

}

@Preview
@Composable
fun ProductUnitPreview() {
    ProductUnit(mockFridgeProduct().first())
}