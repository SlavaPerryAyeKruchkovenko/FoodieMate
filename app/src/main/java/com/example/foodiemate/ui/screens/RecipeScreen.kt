package com.example.foodiemate.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.data.IndexObject
import com.example.foodiemate.data.SearchData
import com.example.foodiemate.data.models.FridgeProduct
import com.example.foodiemate.data.models.Recipe
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.navigations.NavigationAppBar
import com.example.foodiemate.ui.product.FridgeProductView
import com.example.foodiemate.ui.recipe.RecipeCardsView
import com.example.foodiemate.ui.recipe.RecipeFilterView
import com.example.foodiemate.ui.recipe.RecipeFiltersView
import com.example.foodiemate.ui.theme.Blue400
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White
import java.util.Calendar
import java.util.GregorianCalendar

@Composable
fun RecipeScreen() {
    val recipes = Mock.mockRecipes()
    val lastDate = GregorianCalendar().apply {
        add(Calendar.DAY_OF_MONTH,-1)
    }.time
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        NavigationAppBar(
            recipes.map { SearchData(it.id, it.name) },
            stringResource(id = R.string.recipes)
        )
        RecipeFiltersView(recipes.map { x -> x.category })
        RecipeCardsView(recipes.filter { x -> x.isFollow }, R.string.follows_recipes)
        RecipeCardsView(recipes.filter { x -> x.score > 4 }, R.string.popular_recipes)
        RecipeCardsView(recipes.filter { x -> x.date >  lastDate}, R.string.new_recipes)
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    RecipeScreen()
}