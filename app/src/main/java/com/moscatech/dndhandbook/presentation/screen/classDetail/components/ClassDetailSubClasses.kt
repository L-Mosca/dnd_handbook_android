package com.moscatech.dndhandbook.presentation.screen.classDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.util.MockData
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson700

@Composable
fun ClassDetailSubClasses(subClasses: List<DefaultObject> = emptyList()) {
    if (subClasses.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.sub_classes),
            titleColor = Crimson700,
            lineColor = Crimson700,
        )
        subClasses.forEach { BaseText(text = it.name, color = Crimson700) }
    }
    Spacer(Modifier.height(30.dp))
}

@Preview
@Composable
fun ClassDetailSubClassesPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSubClasses(subClasses = mockData.subclasses)
}