package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 18.sp,
    color: Color = Gray100,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.W600,
    textAlign: TextAlign = TextAlign.Start,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    lineHeight: TextUnit = TextUnit.Unspecified,
) {
    return Text(
        text = text,
        fontSize = fontSize,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        minLines = minLines,
        modifier = modifier,
        lineHeight = lineHeight,
    )
}

@Preview
@Composable
fun BaseTextPreview() {
    BaseText(text = "Preview")
}