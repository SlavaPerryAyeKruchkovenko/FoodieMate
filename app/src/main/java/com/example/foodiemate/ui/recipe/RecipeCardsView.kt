package com.example.foodiemate.ui.recipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.data.IndexObject
import com.example.foodiemate.data.models.Recipe
import com.example.foodiemate.data.models.RecipeCategory
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.screens.RecipeScreen
import com.example.foodiemate.ui.theme.Blue700

@Composable
fun RecipeCardsView(recipes: List<Recipe>, title: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
    ) {
        Text(
            stringResource(id = title), fontSize = 16.sp,
            color = Blue700,
            style = TextStyle(lineHeight = 24.sp),
            fontWeight = FontWeight.Medium
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(top = 4.dp)
        ) {
            items(recipes.mapIndexed { i: Int, recipe: Recipe ->
                IndexObject(i, recipe)
            }) {
                Box(
                    modifier = Modifier
                        .widthIn(
                            (LocalConfiguration.current.screenWidthDp / 2 - 12).dp,
                            (LocalConfiguration.current.screenWidthDp / 2 - 12).dp
                        )
                        .composed {
                            when (it.index) {
                                0 -> Modifier.padding(
                                    end = 8.dp
                                )

                                recipes.size - 1 -> Modifier.padding(
                                    start = 8.dp
                                )

                                else -> Modifier.padding(
                                    end = 8.dp,
                                    start = 8.dp
                                )
                            }
                        }
                ) {
                    RecipeCardView(recipe = it.value)
                }
            }
        }
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeCardsView(Mock.mockRecipes(), R.string.follows_recipes)
}
