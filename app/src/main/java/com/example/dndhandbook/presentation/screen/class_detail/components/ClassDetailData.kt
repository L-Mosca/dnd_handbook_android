package com.example.dndhandbook.presentation.screen.class_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.domain.models.class_detail.ClassDetail
import com.example.dndhandbook.presentation.screen.monster_detail.components.basic_data.MonsterName

@Composable
fun ClassDetailData(classDetail: ClassDetail? = null) {
    if (classDetail == null) return

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp)
    ) {
        with(classDetail) {
            item { MonsterName(name = name) }

        }
    }
}

@Preview
@Composable
fun ClassDetailDataPreview() {
    ClassDetailData()
}