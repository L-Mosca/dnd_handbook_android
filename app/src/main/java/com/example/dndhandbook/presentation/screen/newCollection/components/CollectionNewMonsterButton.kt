package com.example.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseButton

@Composable
fun CollectionNewMonsterButton(onClick: (() -> Unit) = {}) {
    BaseButton(
        text = stringResource(R.string.add_monster),
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