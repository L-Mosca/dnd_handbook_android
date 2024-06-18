package com.example.dndhandbook.presentation.screen.create_character.components.race

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.race.RaceBasicData
import com.example.dndhandbook.presentation.base_components.BaseText

@Composable
fun RaceItem(
    onItemSelected: (() -> Unit),
    raceData: RaceBasicData = RaceBasicData(),
    index: Int = 0
) {
    val colorResourceId = if (index % 2 == 0) R.color.black_800 else R.color.black_900
    val color = colorResource(id = colorResourceId)

    Box(modifier = Modifier.background(color)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemSelected() }
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
                tint = colorResource(id = R.color.crimson_800),
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp)
                    .clickable {

                    }
            )
        }
    }

}


@Preview
@Composable
fun RaceItemPreview() {
    RaceItem(onItemSelected = {}, raceData = RaceBasicData(name = "Dwarf"))
}