package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeRemoveProduct() {
    Card(
        modifier = Modifier
            .border(0.dp, Color.Red, RoundedCornerShape(0.dp))
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            CustomTheme.colors.removeProductBackgroud,
        ),
        shape = RoundedCornerShape(CustomTheme.shapeRadius.card),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.remove_product),
                tint = CustomTheme.colors.secondaryText,
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(R.string.remove),
                fontSize = 14.sp,
                color = CustomTheme.colors.secondaryText
            )
        }
    }
}