package com.example.dndhandbook.presentation.screen.bestiary.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseSearchTextField

@Composable
fun SearchMonsterField(onValueChanged: ((String) -> Unit)) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BaseSearchTextField(
            hintText = stringResource(id = R.string.search_monster),
            onValueChange = { onValueChanged.invoke(it) },
            onSearchClicked = { })
    }
}

@Preview
@Composable
fun SearchMonsterFieldPreview() {
    SearchMonsterField(onValueChanged = {})
}