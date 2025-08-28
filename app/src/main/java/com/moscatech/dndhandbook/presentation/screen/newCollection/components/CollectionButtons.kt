package com.moscatech.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.baseComponents.button.BaseButton
import com.moscatech.dndhandbook.presentation.ui.theme.Black700
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Transparent
import com.moscatech.dndhandbook.presentation.ui.theme.White

@Composable
fun CollectionButtons(
    onSaveClicked: (() -> Unit)? = null,
    onDeleteCollectionClicked: (() -> Unit)? = null,
    showDeleteButton: Boolean = true,
) {
    Surface(
        color = Black700,
        shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            CollectionSaveButton { onSaveClicked?.invoke() }
            if (showDeleteButton) CollectionDeleteButton { onDeleteCollectionClicked?.invoke() }
        }
    }
}

@Composable
private fun CollectionDeleteButton(onDeleteClicked: () -> Unit = {}) {
    BaseButton(
        text = stringResource(R.string.delete),
        onClick = { onDeleteClicked.invoke() },
        modifier = Modifier.fillMaxWidth(),
        colors = Transparent,
        fontColor = White,
        border = BorderStroke(width = 1.dp, color = Crimson800),
    )
}

@Composable
private fun CollectionSaveButton(onSaveClicked: () -> Unit = {}) {
    BaseButton(
        text = stringResource(R.string.save),
        onClick = { onSaveClicked.invoke() },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun CollectionButtonsPreview() {
    CollectionButtons(showDeleteButton = true)
}