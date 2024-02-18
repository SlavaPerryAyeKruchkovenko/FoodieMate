package com.example.foodiemate.ui.screens.fridge

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.IndexObject
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.navigations.NavigationBottomBar
import com.example.foodiemate.ui.screens.fridge.views.FridgeProductView
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FridgeScreen(navController: NavHostController, viewModel: FridgeViewModel) {
    val products = Mock.mockFridgeProduct()
    val endMargin = CustomTheme.layoutPadding.mediumPadding
    val bottomMargin =
        CustomTheme.layoutSize.navigationBottomBarHeight + CustomTheme.layoutPadding.mediumPadding
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBottomBar(navController)
        },
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (content, fab) = createRefs()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(content) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            bottom = CustomTheme.layoutSize.navigationBottomBarHeight,
                            start = CustomTheme.layoutPadding.smallPadding,
                            end = CustomTheme.layoutPadding.smallPadding
                        )
                ) {
                    items(products.mapIndexed { i: Int, product: FridgeProduct ->
                        IndexObject(i, product)
                    }) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 8.dp)
                        ) {
                            FridgeProductView(product = it.value)
                        }
                    }
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .size(CustomTheme.layoutSize.addProductButtonSize)
                    .constrainAs(fab) {
                        bottom.linkTo(parent.bottom, margin = bottomMargin)
                        end.linkTo(parent.end, margin = endMargin)
                    },
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                containerColor = CustomTheme.colors.addProductsButtonBackground,
                shape = RoundedCornerShape(50),
                onClick = {}
            ) {
                Icon(
                    Icons.Filled.Add,
                    stringResource(R.string.add_products),
                    tint = CustomTheme.colors.addProductsIconTint,
                    modifier = Modifier.size(CustomTheme.layoutSize.mediumIconSize)
                )
            }
        }
    }
}