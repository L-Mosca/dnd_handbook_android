package com.example.dndhandbook.presentation.screen.bestiary.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.base_components.BaseText

@Composable
fun MonsterCard(monster: DefaultObject, index: Int, onItemClick: (DefaultObject) -> Unit) {
    MonsterLayout(monster, index, onItemClick)
}

@Composable
fun MonsterLayout(monster: DefaultObject, index: Int, onItemCLick: (DefaultObject) -> Unit) {
    val colorResourceId = if (index % 2 == 0) R.color.black_800 else R.color.black_900
    val color = colorResource(id = colorResourceId)
    val paddingTop = if (index == 0) 50.dp else 20.dp
    monster.apply {
        Box(modifier = Modifier.background(color)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemCLick(monster) }
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = paddingTop),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                BaseText(
                    text = monster.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    textOverflow = TextOverflow.Ellipsis
                )

                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = monster.name,
                    tint = colorResource(id = R.color.crimson_800),
                    modifier = Modifier.size(width = 30.dp, height = 30.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MonsterCardPreview() {
    MonsterLayout(
        DefaultObject(
            index = "adult-black-dragon",
            name = "Adult black dragon",
            url = "/adult_black_dragon"
        ),
        index = 0
    ) {}
}