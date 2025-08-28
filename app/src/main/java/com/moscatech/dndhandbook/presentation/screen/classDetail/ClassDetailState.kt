package com.moscatech.dndhandbook.presentation.screen.classDetail

import com.moscatech.dndhandbook.domain.models.class_detail.ClassDetail

data class ClassDetailState (
    val classDetail: ClassDetail? = ClassDetail(),
    val isLoading: Boolean = false,
    val error: String = ""
)