@file:OptIn(ExperimentalMaterial3Api::class)

package com.moscatech.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.presentation.baseComponents.BaseTopBar
import com.moscatech.dndhandbook.presentation.ui.theme.Gold700

@Composable
fun NewCollectionTopBar(
    onBackPressed: (() -> Unit)? = null,
    onDownloadPressed: (() -> Unit) = {},
    onSharePressed: (() -> Unit) = {},
) {
    BaseTopBar(
        title = stringResource(R.string.collection),
        onBackClick = onBackPressed,
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_download),
                tint = Gold700,
                contentDescription = stringResource(R.string.download),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onDownloadPressed.invoke() },
            )
            Spacer(Modifier.width(24.dp))
            Icon(
                painter = painterResource(R.drawable.ic_share),
                tint = Gold700,
                contentDescription = stringResource(R.string.share),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onSharePressed.invoke() },
            )
            Spacer(Modifier.width(18.dp))
        },
    )
}

@Preview
@Composable
private fun NewCollectionTopBarPreview() {
    NewCollectionTopBar {}
}