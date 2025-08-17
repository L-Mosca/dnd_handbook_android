package com.example.dndhandbook.presentation.baseComponents

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        modifier = modifier,
        title = { Title(title) },
        navigationIcon = { BackIcon(title, onBackClick) },
        scrollBehavior = scrollBehavior,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black700,
            titleContentColor = White,
            navigationIconContentColor = White,
            scrolledContainerColor = Black700,
        )
    )
}

@Composable
private fun Title(title: String) {
    BaseText(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.W700,
        maxLines = 1,
        textOverflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun BackIcon(title: String, onBackClick: (() -> Unit)? = null) {
    IconButton(onClick = onBackClick ?: {}) {
        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = title)
    }
}

@ExperimentalMaterial3Api
@Composable
@Preview
private fun BaseTopBarPreview() {
    BaseTopBar(title = "bar title")
}

sealed class TopBarActionDefaults(
    @StringRes val descriptionRes: Int,
    val icon: @Composable (() -> Unit) = {},
    val onClick: () -> Unit = {},
) {
    class Share(onClick: () -> Unit) : TopBarActionDefaults(
        descriptionRes = R.string.share,
        onClick = onClick,
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_share),
                tint = Crimson800,
                contentDescription = stringResource(R.string.share),
            )
        },
    )

    class Download(onClick: () -> Unit) : TopBarActionDefaults(
        descriptionRes = R.string.download,
        onClick = onClick,
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_download),
                tint = Crimson800,
                contentDescription = stringResource(R.string.download)
            )
        },
    )
}