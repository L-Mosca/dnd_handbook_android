package com.example.dndhandbook.presentation.screen.newCollection.components.dialogs

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.dialog.BaseAlertDialog
import com.example.dndhandbook.presentation.ui.theme.Gold700

@Composable
fun CollectionChangesDialog(
    show: Boolean,
    onConfirmation: (() -> Unit) = {},
    onDismiss: (() -> Unit) = {},
) {
    if (!show) return

    BaseAlertDialog(
        onConfirmation = onConfirmation,
        onDismissRequest = onDismiss,
        dialogTitle = stringResource(R.string.save),
        dialogText = stringResource(R.string.save_changes),
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_save),
                tint = Gold700,
                modifier = Modifier.size(50.dp),
                contentDescription = stringResource(R.string.download)
            )
        },
    )
}

@Preview
@Composable
private fun CollectionChangesDialogPreview() {
    CollectionChangesDialog(show = true)
}