package com.example.dndhandbook.presentation.base_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R

@Composable
fun BaseText(
    text: String,
    fontSize: TextUnit = 14.sp,
    color: Color = colorResource(id = R.color.gray_100),
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.W600,
    textAlign: TextAlign = TextAlign.Start,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    padding: Dp = 0.dp
) {
    DndText(
        text = text,
        fontSize = fontSize,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        textOverflow = textOverflow,
        maxLines = maxLines,
        minLines = minLines,
        padding = padding
    )
}


@Composable
fun DndText(
    text: String,
    fontSize: TextUnit = 14.sp,
    color: Color = colorResource(id = R.color.gray_100),
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.W600,
    textAlign: TextAlign = TextAlign.Start,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    padding: Dp = 0.dp
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        minLines = minLines,
        modifier = Modifier.padding(padding)
    )
}


@Preview
@Composable
fun BaseTextPreview() {
    DndText(text = "Teste de renderização")
}