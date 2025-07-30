package com.example.dndhandbook.presentation.baseComponents.placeHolders

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.gif.BaseLottieGif

@Composable
fun LoadingPlaceHolder(modifier: Modifier = Modifier, show: Boolean = true) {
    BaseLottieGif(
        rawRes = R.raw.loading_anim,
        modifier = modifier.size(100.dp),
        show = show,
    )
}

@Preview
@Composable
fun LoadingPlaceHolderPreview() {
    LoadingPlaceHolder()
}