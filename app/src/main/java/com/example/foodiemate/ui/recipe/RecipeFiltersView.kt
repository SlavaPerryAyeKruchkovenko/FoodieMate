package com.example.foodiemate.ui.recipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.data.IndexObject
import com.example.foodiemate.data.models.RecipeCategory
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.Blue700

@Composable
fun RecipeFiltersView(recipeCategories: List<RecipeCategory>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
    ) {
        Text(
            stringResource(id = R.string.filters), fontSize = 14.sp,
            color = Blue700,
            style = TextStyle(lineHeight = 24.sp),
            fontWeight = FontWeight.Medium
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(65.dp)
                .padding(top = 4.dp)
        ) {
            items(recipeCategories.mapIndexed { i: Int, recipe: RecipeCategory ->
                IndexObject(i, recipe)
            }) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .composed {
                            when (it.index) {
                                0 -> Modifier.padding(
                                    end = 8.dp
                                )

                                recipeCategories.size - 1 -> Modifier.padding(
                                    start = 8.dp
                                )

                                else -> Modifier.padding(
                                    end = 8.dp,
                                    start = 8.dp
                                )
                            }
                        }
                ) {
                    RecipeFilterView(recipeCategory = it.value, 80.dp, 100.dp)
                }
            }
        }

    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeFiltersView(Mock.mockCategory())
}