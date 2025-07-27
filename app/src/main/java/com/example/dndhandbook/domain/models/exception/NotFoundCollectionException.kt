package com.example.dndhandbook.domain.models.exception

import androidx.annotation.StringRes
import com.example.dndhandbook.R

data class NotFoundCollectionException(
    @StringRes val messageResId: Int = R.string.not_found_collection_exception
) : RuntimeException()