package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Gold500
import com.example.dndhandbook.presentation.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    onBackPressed: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {


    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Black800,
            titleContentColor = Gold500,
        ),
        title = { Title(title) },
        navigationIcon = { BackIcon(onBackPressed) },
        scrollBehavior = scrollBehavior,
    )
}

@Composable
private fun Title(title: String) {
    BaseText(
        text = title,
        maxLines = 1,
        textOverflow = TextOverflow.Ellipsis,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700
    )
}

@Composable
private fun BackIcon(onBackPressed: (() -> Unit)? = null, contentDescription: String = "") {
    IconButton(onClick = { onBackPressed?.invoke() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = contentDescription,
            tint = Gray100,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BaseTopBarPreview() {
    BaseTopBar(title = "Top bar preview")
}