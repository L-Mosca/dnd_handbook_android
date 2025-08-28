package com.moscatech.dndhandbook.presentation.screen.newCollection.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.baseComponents.placeHolders.EmptyContentPlaceHolder
import com.moscatech.dndhandbook.presentation.ui.theme.Black700
import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Gray100
import com.moscatech.dndhandbook.utils.isPreview

@Composable
fun CollectionMonsterList(
    modifier: Modifier = Modifier,
    list: List<DefaultObject> = emptyList(),
    onDeleteClicked: ((DefaultObject) -> Unit)? = null,
    onInfoClicked: ((DefaultObject) -> Unit)? = null,
) {

    if (isPreview() && list.isEmpty()) {
        EmptyPlaceHolder(true)
        return
    }

    Box(modifier = modifier) {
        EmptyPlaceHolder(list.isEmpty())

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            itemsIndexed(list) { _, monster ->
                CollectionMonsterCard(
                    monster = monster,
                    onDeleteClicked = { onDeleteClicked?.invoke(it) },
                    onInfoClicked = { onInfoClicked?.invoke(it) }
                )
            }
        }
    }
}

@Composable
private fun EmptyPlaceHolder(show: Boolean) {
    EmptyContentPlaceHolder(
        message = stringResource(R.string.no_monsters_found),
        show = show,
    )
}

@Composable
private fun CollectionMonsterCard(
    monster: DefaultObject,
    onDeleteClicked: ((DefaultObject) -> Unit)? = null,
    onInfoClicked: ((DefaultObject) -> Unit)? = null,
) {
    Surface(
        tonalElevation = 2.dp,
        shadowElevation = 2.dp,
        color = Black700,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(Black800)
            .fillMaxWidth()
            .padding(horizontal = 10.dp)

    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BaseText(
                text = monster.name,
                color = Gray100,
                fontSize = 16.sp,
                maxLines = 1,
                textOverflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 10.dp, bottom = 10.dp)
            )

            Icon(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = monster.name,
                tint = Crimson800,
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp)
                    .clickable { onDeleteClicked?.invoke(monster) }
            )

            Spacer(Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = monster.name,
                tint = Crimson800,
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp)
                    .clickable { onInfoClicked?.invoke(monster) }
            )
        }
    }
}

@Preview
@Composable
private fun CollectionMonsterListPreview() {
    CollectionMonsterList(
        list = listOf(
            DefaultObject(name = "Adult brass dragon"),
            DefaultObject(name = "Adult brass dragon"),
            DefaultObject(name = "Adult brass dragon"),
        )
    )
}

@Preview
@Composable
private fun CollectionMonsterEmptyListPreview() {
    CollectionMonsterList()
}