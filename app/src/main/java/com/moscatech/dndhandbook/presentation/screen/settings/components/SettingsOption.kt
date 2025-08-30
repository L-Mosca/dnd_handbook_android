package com.moscatech.dndhandbook.presentation.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.baseComponents.HexagonBox
import com.moscatech.dndhandbook.presentation.ui.theme.Gold600

@Composable
fun SettingsOption(
    text: String,
    hexagonColor: Color = Gold600,
    onOptionClicked: (() -> Unit) = {},
    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onOptionClicked.invoke() }
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .padding(start = 30.dp),
    ) {
        HexagonBox(
            items = { },
            borderColor = hexagonColor,
            internalPadding = 6.dp,
            color = hexagonColor,
        )
        BaseText(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp),
        )
    }
}

@Preview
@Composable
fun SettingsOptionPreview() {
    SettingsOption(text = "Setting name")
}