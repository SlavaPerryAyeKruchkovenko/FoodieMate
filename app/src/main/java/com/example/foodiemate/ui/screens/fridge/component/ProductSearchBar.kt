package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSearchBar(modifier: Modifier, products: List<FridgeProduct>) {
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .background(CustomTheme.colors.bottomNavigationBackground)
            .padding(CustomTheme.layoutPadding.appBarPadding),
        verticalAlignment = Alignment.CenterVertically

    ) {
        var query by remember { mutableStateOf("") }
        val interactionSource = remember { MutableInteractionSource() }
        val productsLabel = stringResource(id = R.string.products)
        BasicTextField(
            modifier = Modifier
                .weight(0.8f)
                .padding(0.dp)
                .background(
                    CustomTheme.colors.secondaryBackground,
                    RoundedCornerShape(CustomTheme.shapeRadius.searchBarCorner)
                ),
            value = query,
            onValueChange = {
                query = it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = CustomTheme.colors.primaryText,
                lineHeight = 20.sp,
            ),
        ) {}
        Column(
            modifier = Modifier
                .weight(0.2f)
                .height(CustomTheme.layoutSize.productAppBarIcon)
                .padding(start = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.shop), contentDescription = productsLabel
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = productsLabel,
                color = CustomTheme.colors.bottomNavigationTextSelected,
                fontSize = 16.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun ProductSearchBarPreview() {
    ProductSearchBar(Modifier, Mock.mockFridgeProduct())
}