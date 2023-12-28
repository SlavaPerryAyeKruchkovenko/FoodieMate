package com.example.foodiemate.ui.recipe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.data.models.Recipe
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.Blue200
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.CategoryColor
import com.example.foodiemate.ui.theme.LightOrange
import com.example.foodiemate.ui.theme.Orange
import com.example.foodiemate.utils.RecipeUtils

@Composable
fun RecipeCardView(recipe: Recipe) {
    val scoreColor = RecipeUtils.getRecipeScoreColor(recipe.score)
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Blue700),
        modifier = Modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = Blue200,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Text(
                    recipe.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Orange,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        recipe.score.toString(),
                        color = scoreColor,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                    Image(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 4.dp),
                        contentScale = ContentScale.Fit,
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = stringResource(R.string.rating),
                        colorFilter = ColorFilter.tint(scoreColor)
                    )
                }
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = LightOrange,
                    )
                ) {
                    Text(
                        text = "#${stringResource(id = recipe.category.name)}", modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        fontSize = 12.sp,
                        color = CategoryColor
                    )
                }
                Text(
                    text = "${recipe.kbZhURecipe.calories} ${stringResource(id = R.string.kcal)}",
                    color = Orange,
                    fontSize = 10.sp,
                    lineHeight = 16.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = recipe.category.img),
                    contentDescription = recipe.name,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewProduct() {
    RecipeCardView(Mock.mockRecipes()[0])
}