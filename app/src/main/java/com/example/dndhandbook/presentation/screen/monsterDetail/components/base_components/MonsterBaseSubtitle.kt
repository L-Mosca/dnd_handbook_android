package com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Crimson900

@Composable
fun MonsterBaseSubtitle(
    title: String,
    titleColor: Color = Crimson800,
    lineColor: Color = Crimson900,
    bottomSpace: Dp = 20.dp
) {
    Column {
        BaseText(
            text = title,
            fontSize = 22.sp,
            color = titleColor,
            fontWeight = FontWeight.W600
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(lineColor)
        )
        Spacer(modifier = Modifier.height(bottomSpace))
    }
}


@Preview
@Composable
fun MonsterBaseSubtitlePreview() {
    MonsterBaseSubtitle(title = stringResource(id = R.string.actions))
}