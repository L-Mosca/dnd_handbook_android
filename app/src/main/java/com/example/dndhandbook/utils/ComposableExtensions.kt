package com.example.dndhandbook.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode

@Composable
fun isPreview(): Boolean = LocalInspectionMode.current
