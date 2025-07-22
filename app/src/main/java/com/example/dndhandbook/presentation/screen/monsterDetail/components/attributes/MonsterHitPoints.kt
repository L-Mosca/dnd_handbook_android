package com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun MonsterHitPoints(hitPoints: String = "", hitPointsRoll: String = "") {

    if (hitPoints.isBlank() && hitPointsRoll.isBlank()) return

    MonsterBasicText(
        title = stringResource(id = R.string.hit_points),
        description = "$hitPoints ($hitPointsRoll)"
    )
}

@Preview
@Composable
fun MonsterHitPointsPreview() {
    val hitPoints = "367"
    val hitPointsRoll = "21d20 + 147"
    MonsterHitPoints(hitPoints, hitPointsRoll)
}