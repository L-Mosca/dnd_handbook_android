package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dndhandbook.R

@Composable
fun BaseRemoteImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentDescription: String = stringResource(R.string.network_image),
    contentScale: ContentScale = ContentScale.Crop,
    elevation: Dp = 0.dp,
    color: Color = Transparent,
    shape: Shape = RectangleShape,
    loadingPlaceholder: @Composable () -> Unit = { BaseLoading(modifier = Modifier.size(50.dp)) },
    errorPlaceholder: @Composable () -> Unit = { ErrorPlaceholder(modifier, contentDescription) }
) {
    if (imageUrl.isNullOrEmpty()) return

    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    Surface(
        shape = shape,
        color = color,
        tonalElevation = elevation,
        shadowElevation = elevation,
        modifier = modifier,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                modifier = modifier.clip(shape),
                contentDescription = contentDescription,
                contentScale = contentScale,
                alignment = alignment,
                onLoading = {
                    isLoading = true
                    hasError = false
                },
                onSuccess = {
                    isLoading = false
                    hasError = false
                },
                onError = {
                    isLoading = false
                    hasError = true
                },
            )

            when {
                isLoading -> loadingPlaceholder()
                hasError -> errorPlaceholder()
            }
        }
    }
}

@Composable
fun ErrorPlaceholder(modifier: Modifier, contentDescription: String) {
    Image(
        painter = painterResource(id = R.drawable.img_monster_error),
        contentDescription = contentDescription,
        modifier = modifier,
    )
}

@Preview
@Composable
fun BaseRemoteImagePreview() {

}