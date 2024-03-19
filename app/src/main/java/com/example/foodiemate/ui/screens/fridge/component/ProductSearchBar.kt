package com.example.foodiemate.ui.screens.fridge.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ProductSearchBar(modifier: Modifier, onSearch: (query: String) -> Unit) {
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .background(CustomTheme.colors.bottomNavigationBackground)
            .padding(CustomTheme.layoutPadding.appBarPadding),
        verticalAlignment = Alignment.CenterVertically

    ) {
        var query by remember { mutableStateOf("") }
        val productsLabel = stringResource(id = R.string.products)
        Icon(
            modifier = Modifier.weight(0.1f),
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back)
        )
        BasicTextField(
            modifier = Modifier.weight(0.7f),
            value = query,
            onValueChange = {
                if (it.length < 30) {
                    query = it
                    onSearch(it)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Done
            ),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = CustomTheme.colors.secondaryText,
                lineHeight = 20.sp,
                fontFamily = FontFamily.SansSerif
            ),
            cursorBrush = SolidColor(CustomTheme.colors.secondaryText)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        CustomTheme.colors.secondaryBackground,
                        RoundedCornerShape(CustomTheme.shapeRadius.searchBarCorner)
                    )
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(CustomTheme.layoutSize.searchBarIcon)
                        .padding(end = 4.dp),
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = CustomTheme.colors.secondaryText
                )
                it()
            }
        }
        Column(
            modifier = Modifier
                .weight(0.2f)
                .height(CustomTheme.layoutSize.productAppBarIcon)
                .padding(start = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.shop),
                contentDescription = productsLabel,
                tint = CustomTheme.colors.secondaryText
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
    ProductSearchBar(Modifier) {
        Log.d("value", it)
    }
}