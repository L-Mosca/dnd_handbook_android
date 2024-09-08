package com.example.dndhandbook.presentation.screen.class_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.common.util.MockData
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBaseSubtitle

@Composable
fun ClassDetailSubClasses(subClasses: List<DefaultObject> = emptyList()) {
    if (subClasses.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.sub_classes),
            titleColor = R.color.crimson_700,
            lineColor = R.color.crimson_700,
        )
        subClasses.forEach { BaseText(text = it.name, color = colorResource(R.color.crimson_700)) }
    }
    Spacer(Modifier.height(30.dp))
}

@Preview
@Composable
fun ClassDetailSubClassesPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSubClasses(subClasses = mockData.subclasses)
}