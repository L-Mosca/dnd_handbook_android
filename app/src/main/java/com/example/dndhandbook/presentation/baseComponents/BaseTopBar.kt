package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    onBackPressed: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Black800)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackIcon(onBackPressed, title)
        Spacer(Modifier.width(10.dp))
        Title(title)
    }
}

@Composable
private fun Title(title: String) {
    BaseText(
        text = title,
        maxLines = 1,
        textOverflow = TextOverflow.Ellipsis,
        fontSize = 20.sp,
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