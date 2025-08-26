package com.example.dndhandbook.presentation.baseComponents.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.baseComponents.button.BaseButton
import com.example.dndhandbook.presentation.baseComponents.button.BaseTextButton
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Gold600

@Composable
fun BaseAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: @Composable (() -> Unit)? = null,
) {
    AlertDialog(
        containerColor = Black700,
        shape = RoundedCornerShape(10.dp),
        icon = icon,
        title = { Title(dialogTitle) },
        text = { Text(text = dialogText) },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            ) {
                DismissButton(onDismissRequest, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(10.dp))
                ConfirmButton(onConfirmation, Modifier.weight(1f))
            }
        },
    )
}

@Composable
private fun ConfirmButton(onConfirmation: () -> Unit, modifier: Modifier = Modifier) {
    BaseButton(
        modifier = modifier,
        onClick = onConfirmation,
        text = stringResource(R.string.confirm),
    )
}

@Composable
private fun DismissButton(onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    BaseTextButton(
        modifier = modifier,
        onClick = onDismissRequest,
        text = stringResource(R.string.dismiss),
    )
}

@Composable
private fun Title(dialogTitle: String) {
    BaseText(
        text = dialogTitle,
        color = Crimson800,
        fontSize = 22.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun Text(text: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        BaseText(
            text = text,
            color = Gold600,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.wrapContentWidth()
        )
    }
}

@Preview
@Composable
private fun BaseAlertDialogPreview() {
    BaseAlertDialog(
        icon = {
            Icon(painter = painterResource(R.drawable.ic_share), contentDescription = "")
        },
        onConfirmation = {},
        onDismissRequest = {},
        dialogText = "Text inside dialog",
        dialogTitle = "Dialog Title",
    )
}