package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.capitalizeWords
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun MonsterLanguages(languages: String) {
    if (languages.isBlank()) return

    MonsterBasicText(
        title = stringResource(id = R.string.languages),
        description = languages.capitalizeWords()
    )
}


@Preview
@Composable
fun MonsterLanguagesPreview() {
    MonsterLanguages("Common, Draconic")
}