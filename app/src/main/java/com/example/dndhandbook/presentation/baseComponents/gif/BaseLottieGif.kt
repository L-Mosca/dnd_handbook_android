package com.example.dndhandbook.presentation.baseComponents.gif

import androidx.annotation.RawRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCancellationBehavior
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dndhandbook.R
import com.example.dndhandbook.utils.isPreview

@Composable
fun BaseLottieGif(
    modifier: Modifier = Modifier,
    @RawRes rawRes: Int,
    iterations: Int = LottieConstants.IterateForever,
    show: Boolean = true,
) {
    if (isPreview()) {
        Image(
            painter = painterResource(id = R.drawable.img_monster_error),
            contentDescription = null,
            modifier = modifier,
        )
        return
    }

    val composition = rememberLottieComposition(
        LottieCompositionSpec.RawRes(rawRes)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition.value,
        iterations = iterations,
        cancellationBehavior = LottieCancellationBehavior.OnIterationFinish,
    )

    AnimatedVisibility(visible = show, enter = fadeIn(), exit = fadeOut(), modifier = modifier) {
        LottieAnimation(
            modifier = modifier,
            composition = composition.value,
            progress = { progress },
        )
    }
}

@Preview
@Composable
fun BaseLottieGifPreview() {
    BaseLottieGif(rawRes = 0)
}