package com.example.dndhandbook.presentation.base_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R

@Composable
fun BaseErrorMessage(errorMessage: String = "") {
    BaseText(
        text = errorMessage,
        fontSize = 18.sp,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        textOverflow = TextOverflow.Ellipsis,
        padding = 20.dp,
        color = colorResource(id = R.color.crimson_800)
    )
}

@Preview
@Composable
fun BaseErrorMessagePreview() {
    BaseErrorMessage("Default error message")
}