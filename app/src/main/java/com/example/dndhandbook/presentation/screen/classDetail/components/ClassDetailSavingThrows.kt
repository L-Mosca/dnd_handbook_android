package com.example.dndhandbook.presentation.screen.classDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.common.util.MockData
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.ui.theme.Green800

@Composable
fun ClassDetailSavingThrows(savingThrows: List<DefaultObject> = emptyList()) {
    if (savingThrows.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.class_proficiencies),
            titleColor = Green800,
            lineColor = Green800,
        )
        savingThrows.forEach { BaseText(text = it.name, color = Green800) }
    }
}

@Preview
@Composable
fun ClassDetailSavingThrowsPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSavingThrows(savingThrows = mockData.savingThrows)
}