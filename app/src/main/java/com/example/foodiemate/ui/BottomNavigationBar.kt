package com.example.foodiemate.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.blueDark500
import com.example.foodiemate.ui.theme.blueLight700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {
    NavigationBar(containerColor = blueLight700, contentColor = blueDark500) {
        NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.fridge),
                contentDescription = "Fridge",
                Modifier.size(24.dp),
            )
        }, label = {
            Text(text = "Холодильник")
        },colors = NavigationBarItemDefaults.colors(
            indicatorColor = blueDark500
        
        ))
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.recipes),
                contentDescription = "Recipes",
                Modifier.size(24.dp)
            )
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Filled.Place, contentDescription = "default")
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Filled.Place, contentDescription = "default")
        })
    }
}