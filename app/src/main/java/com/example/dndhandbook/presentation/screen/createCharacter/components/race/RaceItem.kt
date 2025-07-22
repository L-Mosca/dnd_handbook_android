package com.example.dndhandbook.presentation.screen.createCharacter.components.race

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Black900
import com.example.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun RaceItem(
    onItemSelected: ((DefaultObject) -> Unit),
    onItemInfoSelected: ((String) -> Unit),
    raceData: DefaultObject = DefaultObject(),
    index: Int = 0
) {
    val color = if (index % 2 == 0) Black800 else Black900

    Box(modifier = Modifier.background(color)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemSelected(raceData) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            BaseText(
                text = raceData.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                textOverflow = TextOverflow.Ellipsis
            )
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = raceData.name,
                tint = Crimson800,
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp)
                    .clickable {
                        onItemInfoSelected.invoke(raceData.index)
                    }
            )
        }
    }

}


@Preview
@Composable
fun RaceItemPreview() {
    RaceItem(onItemSelected = {}, raceData = DefaultObject(name = "Dwarf"), onItemInfoSelected = {})
}