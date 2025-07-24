package com.example.dndhandbook.data.repository.monster

import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.models.base.DefaultObject

interface MonsterRepositoryContract {
    suspend fun fetchAllMonsters(): DefaultList
    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto?

    suspend fun saveMonsterDetail(monster: DefaultObject?)
    suspend fun getMonsterDetail(): DefaultObject?
    suspend fun clearMonsterDetail()
}