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
import com.example.dndhandbook.domain.models.sub_race.LanguageOption
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.ui.theme.Purple500

@Composable
fun ClassDetailStartingEquipmentOptions(startingEquipmentOptions: List<LanguageOption> = emptyList()) {
    if (startingEquipmentOptions.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.starting_equipments_options),
            titleColor = Purple500,
            lineColor = Purple500,
        )
        startingEquipmentOptions.forEach {
            BaseText(
                text = it.desc,
                color = Purple500,
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