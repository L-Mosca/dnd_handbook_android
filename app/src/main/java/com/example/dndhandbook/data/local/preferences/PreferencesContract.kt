package com.example.dndhandbook.data.local.preferences

import com.example.dndhandbook.domain.models.base.DefaultObject

interface PreferencesContract {

    suspend fun saveMonsterDetail(monster: DefaultObject?)
    suspend fun getMonsterDetail(): DefaultObject?
    suspend fun clearMonsterDetail()
}