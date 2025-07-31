package com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseButton

@Composable
fun AddMonsterButton(
    onClick: (() -> Unit)? = null,
    isFromCollection: Boolean = true,
) {
    AnimatedVisibility(
        visible = isFromCollection,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Column {
            Spacer(Modifier.height(20.dp))
            BaseButton(
                text = stringResource(R.string.add_creature),
                onClick = { onClick?.invoke() },
                contentPadding = PaddingValues(vertical = 14.dp, horizontal = 10.dp)

            )
        }
    }
}

@Preview
@Composable
fun AddMonsterButtonPreview() {
    AddMonsterButton()
}