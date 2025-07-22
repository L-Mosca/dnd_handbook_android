package com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText

@Composable
fun MonsterBaseSubtitle(
    title: String,
    @ColorRes titleColor: Int = R.color.crimson_800,
    @ColorRes lineColor: Int = R.color.crimson_900,
    bottomSpace: Dp = 20.dp
) {
    Column {
        BaseText(
            text = title,
            fontSize = 22.sp,
            color = colorResource(id = titleColor),
            fontWeight = FontWeight.W600
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(colorResource(id = lineColor))
        )
        Spacer(modifier = Modifier.height(bottomSpace))
    }
}


@Preview
@Composable
fun MonsterBaseSubtitlePreview() {
    MonsterBaseSubtitle(title = stringResource(id = R.string.actions))
}