package com.moscatech.dndhandbook.presentation.baseComponents

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.ui.theme.Black600
import com.moscatech.dndhandbook.presentation.ui.theme.Black700
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson600
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson700
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Gold700
import com.moscatech.dndhandbook.presentation.ui.theme.Gray400
import com.moscatech.dndhandbook.presentation.ui.theme.Gray500
import com.moscatech.dndhandbook.presentation.ui.theme.Transparent

@Composable
fun BaseSearchTextField(
    text: String = "",
    hintText: String,
    onValueChange: ((String) -> Unit),
    onSearchClicked: ((String) -> Unit)
) {

    var textState by remember { mutableStateOf(TextFieldValue(text)) }
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
                color = Gray500,
            )
        },
        textStyle = TextStyle.Default.copy(
            color = Crimson800,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Black700,
            focusedContainerColor = Black700,
            disabledContainerColor = Black600,
            errorContainerColor = Black700,
            unfocusedTextColor = Gray400,
            focusedTextColor = Crimson700,
            disabledTextColor = Gray500,
            errorTextColor = Crimson600,
            cursorColor = Gold700,
            unfocusedTrailingIconColor = Gray500,
            focusedTrailingIconColor = Crimson800,
            unfocusedIndicatorColor = Transparent,
            disabledIndicatorColor = Transparent,
            focusedIndicatorColor = Transparent,
            errorIndicatorColor = Transparent,
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