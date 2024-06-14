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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.getMonsterActionTitle
import com.example.dndhandbook.domain.models.Actions

@Composable
fun MonsterActions(actions: List<Actions> = emptyList()) {

    if (actions.isEmpty()) return

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
            .wrapContentHeight(),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            MonsterBaseSubtitle(title = stringResource(id = R.string.actions))
            actions.forEach {
                MonsterActionItem(it)
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun MonsterActionItem(action: Actions) {
    val context = LocalContext.current
    MonsterBasicText(
        title = action.getMonsterActionTitle(context),
        titleColor = R.color.gold_700,
        description = action.desc,
    )
}

@Preview
@Composable
fun MonsterActionsPreview() {
    val list = mutableListOf<Actions>()
    list.add(
        Actions(
            name = "Multiattack",
            desc = "The dragon can use its Frightful Presence. It then makes three attacks: one with its bite and two with its claws."
        )
    )
    MonsterActions(list)
}