package com.example.dndhandbook.domain.models.exception

import androidx.annotation.StringRes

data class DuplicateCollectionException(
    @StringRes val message: Int
)