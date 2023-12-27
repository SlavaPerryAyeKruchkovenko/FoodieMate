package com.example.foodiemate.ui.navigations

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.data.SearchData
import com.example.foodiemate.ui.theme.Blue200
import com.example.foodiemate.ui.theme.Blue400
import com.example.foodiemate.ui.theme.Blue700
import com.example.foodiemate.ui.theme.White

@Composable
fun NavigationAppBar(searches: List<SearchData>, placeHolder: String) {
    var isActive by remember {
        mutableStateOf(false)
    }
    var queryString by remember {
        mutableStateOf("")
    }
    val filteredSearches = remember(queryString) {
        searches.filter {
            queryString.isEmpty() || it.name.contains(queryString, ignoreCase = true)
        }
    }
    if (!isActive) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Text(
                text = placeHolder,
                color = Blue700,
                fontSize = 28.sp,
                style = TextStyle(lineHeight = 28.sp),
                modifier = Modifier
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { isActive = true },
                tint = Blue700
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue200)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            ) {
                TextField(
                    value = queryString,
                    onValueChange = {
                        queryString = it
                    },
                    placeholder = {
                        Text(
                            stringResource(id = R.string.search_more),
                            fontSize = 14.sp,
                            color = Blue400
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Blue700, RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp),
                    enabled = isActive,
                    textStyle = TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp),
                            tint = Blue700
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Blue700,
                        focusedContainerColor = White,
                        disabledContainerColor = White,
                        unfocusedContainerColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    filteredSearches.forEach {
                        var isSelected by remember { mutableStateOf(false) }
                        val defaultModifier = Modifier
                            .fillMaxWidth()
                            .clickable { isSelected = true }// обычное изменение
                        val selectModifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Blue400) //Если по колонке нажали
                        Column(
                            modifier = defaultModifier.composed { if (isSelected) selectModifier else Modifier }
                        ) {
                            Text(
                                text = it.name,
                                modifier = Modifier
                                    .padding(vertical = 12.dp, horizontal = 8.dp)
                                    .fillMaxWidth(),
                                color = Blue700
                            )
                            HorizontalDivider(
                                color = if (!isSelected) Blue400 else Color.Transparent,
                                modifier = Modifier
                                    .height(1.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
                BackHandler {
                    if(queryString.isNotEmpty()){
                        queryString = ""
                    }
                    else{
                        isActive = false
                    }
                }
            }
        }
    }
}