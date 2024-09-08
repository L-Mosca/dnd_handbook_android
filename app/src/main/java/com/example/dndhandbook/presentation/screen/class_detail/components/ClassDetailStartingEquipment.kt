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
import com.example.dndhandbook.domain.models.class_detail.Equipment
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBaseSubtitle

@Composable
fun ClassDetailStartingEquipment(startingEquipments: List<Equipment> = emptyList()) {
    if (startingEquipments.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.starting_equipments),
            titleColor = R.color.orange_800,
            lineColor = R.color.orange_800,
        )
        startingEquipments.forEach {
            BaseText(
                it.equipment.name,
                color = colorResource(R.color.orange_800)
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