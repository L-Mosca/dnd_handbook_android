package com.moscatech.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.baseComponents.button.BaseButton

@Composable
fun CollectionNewMonsterButton(onClick: (() -> Unit) = {}) {
    BaseButton(
        text = stringResource(R.string.add_creature),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Preview
@Composable
fun CollectionNewMonsterButtonPreview() {
    CollectionNewMonsterButton()
}