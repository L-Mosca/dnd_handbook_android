package com.example.dndhandbook.presentation.baseComponents

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        modifier = modifier,
        title = { Title(title) },
        navigationIcon = { BackIcon(title, onBackClick) },
        scrollBehavior = scrollBehavior,
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
fun BaseTopBarPreview() {
    BaseTopBar(title = "bar title")
}