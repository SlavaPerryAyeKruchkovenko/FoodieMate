package com.example.foodiemate.data.models

import java.util.Date

data class User(
    val id: String,
    val nickname: String,
    val mail: String,
    val birthday: Date,
    val family: Family
)
