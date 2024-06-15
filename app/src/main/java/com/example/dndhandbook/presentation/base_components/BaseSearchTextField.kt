package com.example.dndhandbook.presentation.base_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R

@Composable
fun BaseSearchTextField(
    hintText: String,
    onValueChange: ((String) -> Unit),
    onSearchClicked: ((String) -> Unit)
) {

    var textState by remember { mutableStateOf(TextFieldValue("")) }
    var iconState by remember { mutableStateOf(Icons.Default.Search) }

    TextField(
        value = textState,
        onValueChange = {
            iconState = if (it.text.isNotBlank()) Icons.Default.Close
            else Icons.Default.Search
            onValueChange.invoke(it.text)
            textState = it
        },
        label = {
            BaseText(
                text = hintText,
                color = colorResource(id = R.color.gray_500)
            )
        },
        textStyle = TextStyle.Default.copy(color = colorResource(id = R.color.crimson_800)),
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = R.color.black_700),
            focusedContainerColor = colorResource(id = R.color.black_700),
            disabledContainerColor = colorResource(id = R.color.black_600),
            errorContainerColor = colorResource(id = R.color.black_700),
            unfocusedTextColor = colorResource(id = R.color.gray_400),
            focusedTextColor = colorResource(id = R.color.crimson_700),
            disabledTextColor = colorResource(id = R.color.gray_500),
            errorTextColor = colorResource(id = R.color.crimson_600),
            cursorColor = colorResource(id = R.color.gold_700),
            unfocusedTrailingIconColor = colorResource(id = R.color.gray_500),
            focusedTrailingIconColor = colorResource(id = R.color.crimson_800),
            unfocusedIndicatorColor = colorResource(id = R.color.transparent),
            disabledIndicatorColor = colorResource(id = R.color.transparent),
            focusedIndicatorColor = colorResource(id = R.color.transparent),
            errorIndicatorColor = colorResource(id = R.color.transparent),
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_monster)
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearchClicked.invoke(textState.text) })

    )
}

@Preview
@Composable
fun BaseSearchTextFieldPreview() {
    BaseSearchTextField(onValueChange = {}, hintText = "teste", onSearchClicked = {})
}