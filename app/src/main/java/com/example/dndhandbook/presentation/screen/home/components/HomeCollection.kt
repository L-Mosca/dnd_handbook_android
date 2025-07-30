package com.example.dndhandbook.presentation.screen.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Black600
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.presentation.ui.theme.Gold700
import com.example.dndhandbook.presentation.ui.theme.Gray100

@Composable
fun HomeCollection(
    collectionList: List<MonsterCollection> = emptyList(),
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
    addCollectionClicked: (() -> Unit)? = null,
) {
    Surface(
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        color = Black600,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing,
                )
            ),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Title(addCollectionClicked)
            CollectionList(collectionList, onCollectionClicked, show = collectionList.isNotEmpty())
            CollectionEmptyList(show = collectionList.isEmpty())
        }
    }
}

@Composable
private fun Title(addCollectionClicked: (() -> Unit)? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BaseText(
            text = stringResource(R.string.collections),
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(R.drawable.ic_add),
            contentDescription = stringResource(R.string.create_new_collection),
            tint = Crimson800,
            modifier = Modifier
                .size(30.dp)
                .clickable { addCollectionClicked?.invoke() }
        )
    }
}

@Composable
private fun CollectionList(
    collectionList: List<MonsterCollection> = emptyList(),
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
    show: Boolean = true,
) {
    AnimatedVisibility(visible = show, enter = fadeIn(), exit = fadeOut()) {
        LazyColumn(
            modifier = Modifier.background(Black600),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            itemsIndexed(collectionList) { index, collection ->
                Surface(
                    color = Black700,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(
                            top = if (index == 0) 50.dp else 4.dp,
                            bottom = if (index == collectionList.lastIndex) 30.dp else 0.dp,
                        )
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
}

@Composable
private fun CollectionEmptyList(show: Boolean = false) {
    AnimatedVisibility(visible = show, enter = fadeIn(), exit = fadeOut()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(50.dp))
            BaseText(
                text = stringResource(R.string.not_collections_found),
                fontSize = 18.sp,
                color = Gold700
            )
            Spacer(Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.ic_box),
                contentDescription = stringResource(R.string.not_collections_found),
                tint = Crimson800,
                modifier = Modifier.size(100.dp),
            )
            Spacer(Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCollectionPreview() {
    val collections = listOf(
        MonsterCollection(name = "nome da coleção", monsterList = emptyList()),
        MonsterCollection(name = "nome da coleção", monsterList = emptyList()),
        MonsterCollection(name = "nome da coleção", monsterList = emptyList()),
        MonsterCollection(name = "nome da coleção", monsterList = emptyList()),
    )
    HomeCollection(collections)
}

@Preview(showBackground = true)
@Composable
fun HomeCollectionEmptyPreview() {
    HomeCollection()
}