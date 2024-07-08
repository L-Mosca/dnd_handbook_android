package com.example.dndhandbook.domain.repository.monster

import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList

interface MonsterRepository {
    suspend fun fetchAllMonsters(): DefaultList
    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto?
}