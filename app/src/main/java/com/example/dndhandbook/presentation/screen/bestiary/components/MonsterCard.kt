package com.example.dndhandbook.presentation.screen.bestiary.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import com.example.dndhandbook.domain.models.MonsterBasicData
import com.example.dndhandbook.presentation.base_components.BaseText

@Composable
fun MonsterCard(monster: MonsterBasicData, onItemClick: (MonsterBasicData) -> Unit) {
    MonsterLayout(monster, onItemClick)
}

@Composable
fun MonsterLayout(monster: MonsterBasicData, onItemCLick: (MonsterBasicData) -> Unit) {
    monster.apply {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemCLick(monster) }
                .padding(20.dp),
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

/*@Composable
fun MonsterImage(image: String) {
    val context = LocalContext.current

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(image)
            .crossfade(true)
            .placeholder(R.drawable.img_monster_loading)
            .error(R.drawable.img_monster_error)
            .build()
    )

    Image(
        painter = painter,
        contentDescription = image,
        modifier = Modifier.size(width = 200.dp, height = 200.dp),
        contentScale = ContentScale.Fit
    )
}*/

@Preview
@Composable
fun MonsterCardPreview() {
    MonsterLayout(
        MonsterBasicData(
            index = "adult-black-dragon",
            name = "Adult black dragon",
            url = "/adult_black_dragon"
        )
    ) {}
}