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
import com.example.dndhandbook.domain.models.sub_race.LanguageOption
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBaseSubtitle

@Composable
fun ClassDetailStartingEquipmentOptions(startingEquipmentOptions: List<LanguageOption> = emptyList()) {
    if (startingEquipmentOptions.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.starting_equipments_options),
            titleColor = R.color.purple_500,
            lineColor = R.color.purple_500,
        )
        startingEquipmentOptions.forEach {
            BaseText(
                text = it.desc,
                color = colorResource(R.color.purple_500)
            )
        }
    }
}

@Preview
@Composable
fun ClassDetailStartingEquipmentOptionsPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailStartingEquipmentOptions(startingEquipmentOptions = mockData.startingEquipmentOptions)
}