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
import com.example.dndhandbook.domain.models.sub_race.From
import com.example.dndhandbook.domain.models.sub_race.LanguageOption
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBaseSubtitle

@Composable
fun ClassDetailSkillsOptions(proficiencyChoices: List<LanguageOption> = emptyList()) {
    if (proficiencyChoices.isEmpty()) return

    Column {
        proficiencyChoices.forEach { option ->
            Spacer(Modifier.height(14.dp))
            BaseText(text = "${option.desc}:")
            Spacer(Modifier.height(30.dp))
            OptionList(option = option.from)
        }
    }
}

@Composable
fun OptionList(option: From) {
    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.ability_bonuses),
            titleColor = R.color.blue_800,
            lineColor = R.color.blue_800,
        )
        option.options.forEach { proficiency ->
            BaseText(proficiency.item.name, color = colorResource(id = R.color.blue_500))
        }
    }
}


@Preview
@Composable
fun ClassDetailSkillsOptionsPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSkillsOptions(proficiencyChoices = mockData.proficiencyChoices)
}