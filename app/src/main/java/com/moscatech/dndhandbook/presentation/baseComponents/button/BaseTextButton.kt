package com.moscatech.dndhandbook.presentation.baseComponents.button

import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun BaseTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.W600,
    fontColor: Color = Gray100,
    textDecoration: TextDecoration? = TextDecoration.Underline,
) {

    TextButton(
        onClick = onClick,
        modifier = modifier,
        content = {
            BaseText(
                text = text,
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = fontColor,
                textDecoration = textDecoration,
            )
        },
    )
}

@Preview
@Composable
fun BaseTextButtonPreview() {
    BaseTextButton(
        onClick = {},
        modifier = Modifier,
        text = "Base text button"
    )
}