package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.presentation.ui.theme.Crimson700
import com.example.dndhandbook.presentation.ui.theme.Transparent
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun HexagonBox(
    color: Color = Transparent,
    borderColor: Color = Crimson700,
    borderWidth: Double = 4.0,
    internalPadding: Dp = 20.dp,
    items: @Composable () -> Unit
) {
    val backgroundColor = color
    val border = borderColor

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.wrapContentSize()
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawHexagon(backgroundColor, border, borderWidth)
        }
        Box(modifier = Modifier.padding(internalPadding)) {
            items()
        }
    }
}

fun DrawScope.drawHexagon(backgroundColor: Color, borderColor: Color, borderWidth: Double) {
    val path = Path()
    val width = size.width
    val height = size.height
    val radius = width / 2
    val centerX = width / 2
    val centerY = height / 2

    val points = List(6) { i ->
        val angle = Math.toRadians((i * 60).toDouble() - 30)
        Offset(
            x = centerX + (radius * cos(angle)).toFloat(),
            y = centerY + (radius * sin(angle)).toFloat()
        )
    }

    path.moveTo(points[0].x, points[0].y)
    for (i in 1 until points.size) {
        path.lineTo(points[i].x, points[i].y)
    }
    path.close()

    drawPath(path = path, color = backgroundColor)
    drawPath(path = path, color = borderColor, style = Stroke(width = borderWidth.toFloat()))
}

@Preview
@Composable
fun PreviewHexagonBox() {
    HexagonBox(color = Transparent, borderWidth = 4.0) {
        BaseText(text = "20")
    }
}