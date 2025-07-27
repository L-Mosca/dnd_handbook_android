package com.example.dndhandbook.domain.models.exception

import androidx.annotation.StringRes
import com.example.dndhandbook.R

data class DuplicateCollectionException(
    @StringRes val messageResId: Int = R.string.duplicate_monster_collection
) : RuntimeException()