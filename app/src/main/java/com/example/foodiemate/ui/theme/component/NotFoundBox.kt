package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun NotFoundBox(text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.primaryBackground),
        contentAlignment = Alignment.Center
    ) {
        Text(
            color = CustomTheme.colors.primaryText,
            text = text,
            maxLines = 3,
            fontWeight = FontWeight.Bold,
            fontSize = CustomTheme.fontSize.noItemsFont
        )
    }
}

@Preview
@Composable
fun NotFoundBoxPreview() {
    NotFoundBox(text = stringResource(id = R.string.fridge_is_empty))
}