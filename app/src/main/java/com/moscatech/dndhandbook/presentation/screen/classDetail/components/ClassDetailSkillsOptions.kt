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
import com.moscatech.dndhandbook.domain.models.sub_race.From
import com.moscatech.dndhandbook.domain.models.sub_race.LanguageOption
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.moscatech.dndhandbook.presentation.ui.theme.Blue500
import com.moscatech.dndhandbook.presentation.ui.theme.Blue800

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
            titleColor = Blue800,
            lineColor = Blue800,
        )
        option.options.forEach { proficiency ->
            BaseText(text = proficiency.item.name, color = Blue500)
        }
    }
}


@Preview
@Composable
fun ClassDetailSkillsOptionsPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSkillsOptions(proficiencyChoices = mockData.proficiencyChoices)
}