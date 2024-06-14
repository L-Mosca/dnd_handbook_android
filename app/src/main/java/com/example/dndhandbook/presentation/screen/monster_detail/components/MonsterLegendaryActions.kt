package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.LegendaryActions

@Composable
fun MonsterLegendaryActions(legendaryActions: List<LegendaryActions> = emptyList()) {
    if (legendaryActions.isEmpty()) return

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .wrapContentHeight(),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            MonsterBaseSubtitle(title = stringResource(id = R.string.legendary_actions))
            legendaryActions.forEach { action ->
                MonsterBasicText(
                    title = "${action.name}.",
                    titleColor = R.color.gold_700,
                    description = action.desc
                )
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Preview
@Composable
fun MonsterLegendaryActionsPreview() {
    val list = mutableListOf<LegendaryActions>()
    list.add(
        LegendaryActions(
            name = "Wing Attack (Costs 2 Actions)",
            desc = "The dragon beats its wings. Each creature within 10 ft. of the dragon must succeed on a DC 19 Dexterity saving throw or take 13 (2d6 + 6) bludgeoning damage and be knocked prone. The dragon can then fly up to half its flying speed."
        )
    )
    MonsterLegendaryActions(list)
}