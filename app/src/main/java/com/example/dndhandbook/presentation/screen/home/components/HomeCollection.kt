package com.example.dndhandbook.presentation.screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun HomeCollection(
    collectionList: List<MonsterCollection> = emptyList(),
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
) {

    Surface(
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        color = Black700,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Title()
            CollectionList(collectionList, onCollectionClicked)
        }
    }
}

@Composable
private fun Title() {
    BaseText(
        text = stringResource(R.string.collections),
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
    )
}

@Composable
private fun CollectionList(
    collectionList: List<MonsterCollection> = emptyList(),
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
) {
    LazyColumn(
        modifier = Modifier
            .background(Black700)
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        itemsIndexed(collectionList) { index, collection ->
            Surface(
                color = Black800,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .clickable { onCollectionClicked?.invoke(collection) }

            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BaseText(
                        text = collection.name,
                        color = Gray100,
                        fontSize = 16.sp,
                        maxLines = 1,
                        textOverflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 10.dp, bottom = 10.dp)
                    )

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = collection.name,
                        tint = Crimson800,
                        modifier = Modifier.size(width = 30.dp, height = 30.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCollectionPreview() {
    val collections = listOf(
        MonsterCollection("nome da coleção", emptyList()),
        MonsterCollection("nome da coleção", emptyList()),
        MonsterCollection("nome da coleção", emptyList()),
        MonsterCollection("nome da coleção", emptyList()),
    )
    HomeCollection(collections)
}