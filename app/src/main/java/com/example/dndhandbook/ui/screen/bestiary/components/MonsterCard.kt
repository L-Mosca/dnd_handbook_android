package com.example.dndhandbook.ui.screen.bestiary.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.monster.MonsterBasicData
import com.example.dndhandbook.ui.base_components.BaseText

@Composable
fun MonsterCard(monster: MonsterBasicData) {
    MonsterLayout(monster)
}

@Composable
fun MonsterLayout(monster: MonsterBasicData) {
    monster.apply {
        Card(
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.black_700)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                MonsterImage(image = image)
                MonsterName(name = name)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
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
}

@Composable
fun MonsterName(name: String) {
    BaseText(
        text = name,
        color = colorResource(id = R.color.crimson_600),
        textAlign = TextAlign.Center,
        fontSize = 16.sp
    )
}

@Preview
@Composable
fun MonsterCardPreview() {
    MonsterLayout(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/adult-black-dragon.png"
        )
    )
}