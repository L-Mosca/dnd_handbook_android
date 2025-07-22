package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R

@Composable
fun BaseButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    elevation: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    colors: Color = colorResource(id = R.color.crimson_800),
    text: String,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.W600,
    fontColor: Color = colorResource(id = R.color.gray_100)
) {
    DndButton(
        onClick = onClick,
        text = text,
        enabled = enabled,
        elevation = elevation,
        cornerRadius = cornerRadius,
        colors = colors,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontColor = fontColor
    )
}


@Composable
fun DndButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    elevation: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    colors: Color = colorResource(id = R.color.crimson_800),
    text: String,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.W600,
    fontColor: Color = colorResource(id = R.color.gray_100)
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = elevation),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(containerColor = colors)
    ) {
        BaseText(text = text, fontSize = fontSize, fontWeight = fontWeight, color = fontColor)
    }
}

@Preview
@Composable
fun BaseButtonPreview() {
    DndButton(onClick = {}, text = "Texto do botão")
}