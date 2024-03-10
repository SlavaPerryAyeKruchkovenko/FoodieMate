package com.example.foodiemate.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}