package com.example.dndhandbook.presentation.screen.class_detail

data class ClassDetailState (
    val classDetail: Any? = Any(),
    val isLoading: Boolean = false,
    val error: String = ""
)