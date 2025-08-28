package com.moscatech.dndhandbook.presentation.baseComponents.gif

import android.graphics.drawable.AnimatedImageDrawable
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.request.repeatCount
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.utils.isPreview

@Composable
fun BaseGif(
    @DrawableRes gifRes: Int,
    modifier: Modifier = Modifier,
    show: Boolean = true,
    repeatCount: Int = AnimatedImageDrawable.REPEAT_INFINITE,
    contentDescription: String = stringResource(R.string.gif),
) {
    if (isPreview()) {
        Image(
            painter = painterResource(id = R.drawable.img_monster_error),
            contentDescription = contentDescription,
            modifier = modifier,
        )
        return
    }

    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context).components {
        add(ImageDecoderDecoder.Factory())
    }.build()

    AnimatedVisibility(visible = show, enter = fadeIn(), exit = fadeOut()) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(gifRes)
                .repeatCount(repeatCount)
                .build(),
            imageLoader = imageLoader,
            contentDescription = contentDescription,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
fun BaseGifPreview() {
    BaseGif(R.drawable.gif_ghost)
}