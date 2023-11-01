package com.example.foodiemate.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.data.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.Blue200
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.Orange
import com.example.foodiemate.utils.ProductUtils

@Composable
fun FridgeProductView(product: FridgeProduct) {
    val image = ProductUtils.getProductImage(product.product)
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Blue700),
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Blue200,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = image),
                    contentDescription = product.product.category,
                    modifier = Modifier.width(120.dp)
                )
                Text(
                    product.product.name,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Orange,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    color = Blue700
                )
                Text(
                    "Бренд: ${product.product.category}",
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Blue700,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
                Text(
                    "Кол-во: ${product.count}",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth(),
                    color = Blue700,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProduct() {
    FridgeProductView(Mock.mockFridgeProduct().first())
}