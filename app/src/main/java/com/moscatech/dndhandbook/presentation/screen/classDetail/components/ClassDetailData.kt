package com.moscatech.dndhandbook.presentation.screen.classDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.common.util.MockData
import com.moscatech.dndhandbook.domain.models.class_detail.ClassDetail
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterName

@Composable
fun ClassDetailData(classDetail: ClassDetail? = null) {
    if (classDetail == null) return

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp)
    ) {
        with(classDetail) {
            item { MonsterName(name = name) }
            item { ClassDetailSkillsOptions(proficiencyChoices = proficiencyChoices) }
            item { ClassDetailProficiencies(proficiencies = proficiencies) }
            item { ClassDetailSavingThrows(savingThrows = savingThrows) }
            item { ClassDetailStartingEquipment(startingEquipments = startingEquipment) }
            item { ClassDetailStartingEquipmentOptions(startingEquipmentOptions = startingEquipmentOptions) }
            item { ClassDetailSubClasses(subClasses = subclasses) }
        }
    }
}

@Preview
@Composable
fun ClassDetailDataPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailData(classDetail = mockData)
}