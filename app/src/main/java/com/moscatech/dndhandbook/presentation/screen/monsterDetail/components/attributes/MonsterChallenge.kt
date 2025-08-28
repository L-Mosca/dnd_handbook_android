package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.getMonsterChallenge
import com.moscatech.dndhandbook.common.extensions_functions.getMonsterXp
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

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