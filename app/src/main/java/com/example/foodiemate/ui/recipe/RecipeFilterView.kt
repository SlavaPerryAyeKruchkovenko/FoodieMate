package com.example.foodiemate.ui.recipe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.data.models.RecipeCategory
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.product.FridgeProductView
import com.example.foodiemate.ui.theme.Blue200
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.Orange

@Composable
fun RecipeFilterView(
    recipeCategory: RecipeCategory,
    minWidth: Dp,
    maxWidth: Dp
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Blue700),
        modifier = Modifier
            .fillMaxSize()
            .widthIn(min = minWidth, max = maxWidth),
        colors = CardDefaults.cardColors(
            containerColor = Blue200,
        ),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = recipeCategory.img),
                    contentDescription = stringResource(id = recipeCategory.name),
                    modifier = Modifier.height(26.dp)
                )
                Text(
                    text = stringResource(id = recipeCategory.name),
                    modifier = Modifier.padding(top = 4.dp),
                    color = Orange,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewProduct() {
    RecipeFilterView(Mock.mockCategory()[0], 80.dp, 100.dp)
}