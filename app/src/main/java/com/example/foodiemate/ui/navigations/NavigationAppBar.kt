package com.example.foodiemate.ui.navigations

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.ui.theme.Blue200
import com.example.foodiemate.ui.theme.Blue400
import com.example.foodiemate.ui.theme.Blue700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(searches: List<String>, placeHolder: String) {
    var isActive by remember {
        mutableStateOf(false)
    }
    var queryString by remember {
        mutableStateOf("")
    }
    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = SearchBarDefaults.colors(
            if (isActive) Blue200 else Color.Transparent,
            Color.Transparent,
            TextFieldDefaults.colors(
                focusedTextColor = Blue700
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
            if (!isActive) Text(
                text = placeHolder,
                color = Blue700,
                fontSize = 28.sp,
                style = TextStyle(lineHeight = 28.sp),
                overflow = TextOverflow.Visible,
                modifier = Modifier
                    .height(28.dp)
            ) else {
                Text(text = placeHolder)
            }
        },
        leadingIcon = null,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .offset(0.dp, 4.dp),
                tint = Blue700
            )
        }
    ) {
        searches.forEach {
            var isSelected by remember {
                mutableStateOf(false)
            }
            val defaultModifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clickable {
                    isSelected = true
                }
            val selectModifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Blue400)
            Column(
                modifier = defaultModifier
                    .composed {
                        if (isSelected) selectModifier else Modifier
                    }

            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 8.dp)
                        .fillMaxWidth(),
                    color = Blue700
                )
                if (!isSelected) HorizontalDivider(
                    color = Blue400,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}