package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.attributes.GameAttribute
import com.example.dndhandbook.domain.models.attributes.buildMockList
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.base_components.HexagonBox

@Composable
fun MonsterAttributes(basicAttrs: List<GameAttribute>) {
    if (basicAttrs.isEmpty()) return
    basicAttrs.apply {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(14.dp),
            userScrollEnabled = false,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            items(basicAttrs) { attribute ->
                AttributeContainer(attribute = attribute)
            }
        }
    }
}

@Composable
fun AttributeContainer(attribute: GameAttribute) {
    with(attribute) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseText(text = name, fontSize = 12.sp, color = colorResource(id = color))
            Spacer(modifier = Modifier.height(4.dp))
            HexagonBox(borderColor = color, internalPadding = 30.dp) {
                BaseText(
                    text = level.toString(),
                    color = colorResource(id = R.color.gray_300),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }
    }
}

@Preview
@Composable
fun AttributesPreview() {
    MonsterAttributes(GameAttribute().buildMockList())
}