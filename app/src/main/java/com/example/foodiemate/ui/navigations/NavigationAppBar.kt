package com.example.foodiemate.ui.navigations

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.Blue500
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar() {
    var isActive = false
    var queryString = ""
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = if (isActive) 0.dp else 8.dp),
        colors = SearchBarDefaults.colors(
            White,
            Blue700,
            TextFieldDefaults.colors(
                focusedTextColor = Blue700,
                disabledTextColor = Blue500,
                unfocusedTextColor = Blue700,
                focusedContainerColor = Blue700
            )
        ),
        query = queryString,
        onQueryChange = { newQueryString ->
            queryString = newQueryString
        },
        onSearch = {
            isActive = false
        },
        active = isActive,
        onActiveChange = { activeChange ->
            isActive = activeChange
        },
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
    ) {

    }
}