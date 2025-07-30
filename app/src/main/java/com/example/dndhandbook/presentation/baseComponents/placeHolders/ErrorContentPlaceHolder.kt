package com.example.dndhandbook.presentation.baseComponents.placeHolders

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseButton
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.baseComponents.gif.BaseLottieGif
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Transparent

@Composable
fun ErrorContentPlaceHolder(
    modifier: Modifier = Modifier,
    message: String = "",
    fontSize: TextUnit = 20.sp,
    fontColor: Color = Crimson800,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.W600,
    textAlign: TextAlign = TextAlign.Center,
    onTryAgainClicked: (() -> Unit)? = {},
    color: Color = Transparent,
    show: Boolean = true,
) {
    AnimatedVisibility(
        visible = show,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Surface(
            color = color,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp),
            ) {
                BaseLottieGif(
                    rawRes = R.raw.error_anim,
                    show = show,
                    modifier = Modifier.size(180.dp),
                )
                BaseText(
                    text = message,
                    color = fontColor,
                    fontSize = fontSize,
                    fontStyle = fontStyle,
                    fontWeight = fontWeight,
                    textAlign = textAlign,
                    modifier = Modifier.offset(x = 0.dp, y = (-10).dp),
                )
                Spacer(Modifier.height(14.dp))
                BaseButton(
                    onClick = { onTryAgainClicked?.invoke() },
                    text = stringResource(R.string.try_again),
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun FadeInPreview() {
    ErrorContentPlaceHolder(
        message = stringResource(R.string.unexpected_error),
        show = false,
    )
}

@Preview
@Composable
private fun FadeOutPreview() {
    ErrorContentPlaceHolder(
        message = stringResource(R.string.unexpected_error),
        show = true,
    )
}