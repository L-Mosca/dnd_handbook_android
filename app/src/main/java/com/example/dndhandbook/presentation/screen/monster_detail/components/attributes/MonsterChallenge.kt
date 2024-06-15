package com.example.dndhandbook.presentation.screen.monster_detail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.getMonsterChallenge
import com.example.dndhandbook.common.extensions_functions.getMonsterXp
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText

@Composable
fun MonsterChallenge(challenge: Double = 0.0, xp: Int = 0) {
    if (challenge == 0.0 && xp == 0) return

    MonsterBasicText(
        title = "${stringResource(id = R.string.challenge)} ${challenge.getMonsterChallenge()}",
        description = xp.getMonsterXp()
    )
}

@Preview
@Composable
fun MonsterChallengePreview() {
    MonsterChallenge(14.0, 11500)
}