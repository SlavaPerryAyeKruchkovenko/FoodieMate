package com.example.foodiemate.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R

@Composable
fun FridgeProduct() {
    Card() {
        Column {
            Image(painter = painterResource(id = R.drawable.meat), contentDescription = "product")
            Text("Колбаса")
            HorizontalDivider()
            Text("Бренд: Вязанка")
            Text("Кол-во: 200Г")
        }
    }
}

@Preview
@Composable
fun PreviewProduct() {
    FridgeProduct()
}