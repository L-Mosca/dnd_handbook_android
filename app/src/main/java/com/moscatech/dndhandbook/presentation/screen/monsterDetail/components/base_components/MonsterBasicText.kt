package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Gray400

@Composable
fun MonsterBasicText(
    title: String,
    description: String,
    titleColor: Color = Crimson800,
    descriptionColor: Color = Gray400,
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.W600,
                color = titleColor,
                fontSize = 16.sp,
            )
        ) {
            append(title)
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.W600,
                color = descriptionColor,
                fontSize = 14.sp
            )
        ) {
            append("   $description")
        }
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomStart) {
        BasicText(
            text = annotatedString,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp),
        )
    }
}


@Preview
@Composable
fun MonsterBasicTextPreview() {
    MonsterBasicText(title = "Status title", description = "Status description")
}