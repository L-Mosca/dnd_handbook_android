package com.moscatech.dndhandbook.presentation.screen.collection.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.presentation.ui.theme.Black900
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun CollectionList(
    collectionList: List<MonsterCollection> = emptyList(),
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black800)
    ) {
        itemsIndexed(collectionList) { index, collection ->
            CollectionCard(
                collection = collection,
                index = index,
                onCollectionClicked = onCollectionClicked
            )
        }
    }
}

@Composable
private fun CollectionCard(
    collection: MonsterCollection,
    index: Int,
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
) {
    val colorResourceId = if (index % 2 == 0) Black800 else Black900
    val name =
        collection.name.ifBlank { stringResource(R.string.unnamed_collection) }

    Box(modifier = Modifier.background(colorResourceId)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCollectionClicked?.invoke(collection) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            BaseText(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                textOverflow = TextOverflow.Ellipsis
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

@Preview
@Composable
private fun CollectionListPreview() {
    val list = mutableListOf<MonsterCollection>()
    repeat(10) {
        list.add(MonsterCollection(name = "collection name"))
    }

    CollectionList(collectionList = list)
}