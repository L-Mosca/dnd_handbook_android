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
import com.example.dndhandbook.domain.models.class_detail.Equipment
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.ui.theme.Orange800

@Composable
fun ClassDetailStartingEquipment(startingEquipments: List<Equipment> = emptyList()) {
    if (startingEquipments.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.starting_equipments),
            titleColor = Orange800,
            lineColor = Orange800,
        )
        startingEquipments.forEach {
            BaseText(
                text = it.equipment.name,
                color = Orange800,
            )
        }
    }
}

@Preview
@Composable
fun ClassDetailStartingEquipmentPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailStartingEquipment(startingEquipments = mockData.startingEquipment)
}