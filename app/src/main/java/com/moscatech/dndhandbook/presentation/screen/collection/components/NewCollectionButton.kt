package com.moscatech.dndhandbook.presentation.screen.collection.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.baseComponents.button.BaseButton
import com.moscatech.dndhandbook.presentation.ui.theme.Black700

@Composable
fun NewCollectionButton(modifier: Modifier = Modifier, onNewCollectionClicked: () -> Unit = {}) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Black700,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            )
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.Center,
    ) {
        BaseButton(
            text = stringResource(R.string.create_new_collection),
            onClick = { onNewCollectionClicked.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}

@Preview
@Composable
private fun NewCollectionButtonPreview() {
    NewCollectionButton()
}