package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.extractMonsterSpeed
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun MonsterSpeed(speed: Map<String, String>) {

    if (speed.isEmpty()) return

    MonsterBasicText(
        title = stringResource(id = R.string.speed),
        description = speed.extractMonsterSpeed()
    )
}

@Preview
@Composable
fun MonsterSpeedPreview() {
    val speed = mapOf(
        "walk" to "40 ft.",
        "fly" to "80 ft.",
        "swim" to "40 ft.",
    )
    MonsterSpeed(speed = speed)
}