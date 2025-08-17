package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    colors: Color = Crimson800,
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.W600,
    fontColor: Color = Gray100,
    contentPadding: PaddingValues = PaddingValues(vertical = 14.dp),
    border: BorderStroke? = null,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = elevation),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(containerColor = colors),
        modifier = modifier,
        contentPadding = contentPadding,
        border = border,
    ) {
        BaseText(text = text, fontSize = fontSize, fontWeight = fontWeight, color = fontColor)
    }
}

@Preview
@Composable
fun BaseButtonPreview() {
    BaseButton(onClick = {}, text = "Texto do botão")
}