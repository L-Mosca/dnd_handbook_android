package com.example.dndhandbook.presentation.baseComponents.placeHolders

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.gif.BaseGif

@Composable
fun LoadingPlaceHolder(modifier: Modifier = Modifier, show: Boolean = true) {
    BaseGif(
        gifRes = R.drawable.gif_loading,
        contentDescription = stringResource(R.string.loading_description),
        modifier = modifier.size(100.dp),
        show = show,
    )
}

@Preview
@Composable
fun LoadingPlaceHolderPreview() {
    LoadingPlaceHolder()
}