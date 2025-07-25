package com.example.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseTextField

@Composable
fun CollectionNameTextField(
    text: String = "",
    onValueChange: ((String) -> Unit)? = null,
) {
    BaseTextField(
        text = text,
        hint = stringResource(R.string.collection_name),
        keyboardActions = KeyboardActions(onDone = {}),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        modifier = Modifier.padding(top = 30.dp),
        onValueChange = onValueChange
    )
}

@Preview
@Composable
fun CollectionNameTextFieldPreview() {
    CollectionNameTextField()
}