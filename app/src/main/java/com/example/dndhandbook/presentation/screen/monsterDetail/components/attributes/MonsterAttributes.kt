package com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.domain.models.attributes.GameAttribute
import com.example.dndhandbook.domain.models.attributes.buildMockList
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.baseComponents.HexagonBox
import com.example.dndhandbook.presentation.ui.theme.Gray300

@Composable
fun MonsterAttributes(basicAttrs: List<GameAttribute>) {
    if (basicAttrs.isEmpty()) return
    basicAttrs.apply {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            basicAttrs.forEachIndexed { index, _ ->
                if (index % 3 == 0) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        AttributeContainer(attribute = basicAttrs[index])
                        if (index + 1 < basicAttrs.size) {
                            AttributeContainer(attribute = basicAttrs[index + 1])
                        }
                        if (index + 2 < basicAttrs.size) {
                            AttributeContainer(attribute = basicAttrs[index + 2])
                        }
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun AttributeContainer(attribute: GameAttribute) {
    with(attribute) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.wrapContentHeight(),
        ) {
            BaseText(text = name, fontSize = 12.sp, color = color)
            Spacer(modifier = Modifier.height(4.dp))
            HexagonBox(borderColor = color, internalPadding = 30.dp) {
                BaseText(
                    text = level.toString(),
                    color = Gray300,
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