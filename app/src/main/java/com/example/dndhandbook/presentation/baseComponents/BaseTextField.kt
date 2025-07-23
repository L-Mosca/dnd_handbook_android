package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Black600
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Crimson600
import com.example.dndhandbook.presentation.ui.theme.Crimson700
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Gold700
import com.example.dndhandbook.presentation.ui.theme.Gray400
import com.example.dndhandbook.presentation.ui.theme.Gray500
import com.example.dndhandbook.presentation.ui.theme.Transparent

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    onValueChange: ((String) -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    colors: TextFieldColors? = null,
    textStyle: TextStyle? = null,
) {

    var textState by remember { mutableStateOf(TextFieldValue(text)) }

    TextField(
        value = textState,
        onValueChange = {
            onValueChange?.invoke(it.text)
            textState = it
        },
        label = { BaseText(text = hint, color = Gray500) },
        textStyle = textStyle ?: TextStyle.Default.copy(
            color = Crimson800,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600
        ),
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = colors ?: TextFieldDefaults.colors(
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
        trailingIcon = trailingIcon,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}

@Preview
@Composable
fun BaseTextFieldPreview() {
    BaseTextField(hint = "test hint text")
}