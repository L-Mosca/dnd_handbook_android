package com.moscatech.dndhandbook.presentation.screen.collection.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Gold700

@Composable
fun CollectionEmptyList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_box),
            contentDescription = stringResource(R.string.not_collections_found),
            tint = Crimson800,
            modifier = Modifier.size(140.dp),
        )
        Spacer(Modifier.height(10.dp))
        BaseText(
            text = stringResource(R.string.not_collections_found),
            fontSize = 22.sp,
            color = Gold700
        )
        Spacer(Modifier.height(50.dp))
    }
}

@Preview
@Composable
private fun CollectionEmptyListPreview() {
    CollectionEmptyList()
}