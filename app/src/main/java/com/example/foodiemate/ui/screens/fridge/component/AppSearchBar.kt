package com.example.foodiemate.ui.screens.fridge.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun AppSearchBar(
    modifier: Modifier, navController: NavHostController, onSearch: (query: String) -> Unit
) {
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .background(CustomTheme.colors.bottomNavigationBackground)
            .padding(CustomTheme.layoutPadding.appBarPadding),
        verticalAlignment = Alignment.CenterVertically

    ) {
        var query by remember { mutableStateOf("") }
        Icon(modifier = Modifier
            .size(CustomTheme.layoutSize.searchBarIcon)
            .clickable {
                navController.popBackStack()
            }
            .padding(end = 6.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
            tint = CustomTheme.colors.secondaryText)
        BasicTextField(
            modifier = Modifier.weight(0.9f), value = query, onValueChange = {
                if (it.length < 30) {
                    query = it
                    onSearch(it)
                }
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Done
            ), maxLines = 1, singleLine = true, textStyle = TextStyle(
                fontSize = 16.sp,
                color = CustomTheme.colors.secondaryText,
                lineHeight = 20.sp,
                fontFamily = FontFamily.SansSerif
            ), cursorBrush = SolidColor(CustomTheme.colors.secondaryText)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        CustomTheme.colors.secondaryBackground,
                        RoundedCornerShape(CustomTheme.shapeRadius.searchBarCorner)
                    )
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
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
    }
}

@Preview
@Composable
fun AppSearchBarPreview() {
    val navController = rememberNavController()
    AppSearchBar(Modifier, navController) {
        Log.d("value", it)
    }
}