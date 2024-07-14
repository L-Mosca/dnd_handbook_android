package com.example.dndhandbook.presentation.screen.class_detail

import com.example.dndhandbook.domain.models.class_detail.ClassDetail

data class ClassDetailState (
    val classDetail: ClassDetail? = ClassDetail(),
    val isLoading: Boolean = false,
    val error: String = ""
)