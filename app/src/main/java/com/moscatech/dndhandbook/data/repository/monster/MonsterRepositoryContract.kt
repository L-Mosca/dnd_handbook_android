package com.moscatech.dndhandbook.data.repository.monster

import com.moscatech.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.moscatech.dndhandbook.domain.models.base.DefaultList

interface MonsterRepositoryContract {
    suspend fun fetchAllMonsters(): DefaultList
    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto?
    suspend fun saveAllMonsters()
}