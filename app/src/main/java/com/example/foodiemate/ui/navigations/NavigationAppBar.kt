package com.example.foodiemate.ui.navigations

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar() {
    var isActive by remember {
        mutableStateOf(false)
    }
    var queryString by remember {
        mutableStateOf("")
    }
    SearchBar(
        modifier = Modifier
            .fillMaxWidth().padding(0.dp),
        colors = SearchBarDefaults.colors(
            White,
            Blue700,
            TextFieldDefaults.colors(

            )
        ),
        query = queryString,
        onQueryChange = {
            queryString = it
        },
        onSearch = {
            isActive = false
        },
        active = isActive,
        onActiveChange = {
            isActive = it
        },
        placeholder = {
            Text(text = "Search")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
    ) {

    }
}