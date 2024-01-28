package com.example.foodiemate.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.Blue300
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White

@SuppressLint("UnnecessaryComposedModifier")
@Composable
fun FridgeScreen() {
    val products = Mock.mockFridgeProduct()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
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

        }
        FloatingActionButton(
            modifier = Modifier
                .size(64.dp)
                .constrainAs(fab) {
                    bottom.linkTo(parent.bottom, margin = 104.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                },
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            containerColor = Blue300,
            shape = RoundedCornerShape(50),
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, "", tint = Blue700, modifier = Modifier.size(24.dp))
        }
    }
}

@Preview
@Composable
private fun FridgeScreenPreview() {
    FridgeScreen()
}