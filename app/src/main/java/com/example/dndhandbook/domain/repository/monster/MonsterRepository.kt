package com.example.dndhandbook.domain.repository.monster

import com.example.dndhandbook.data.remote.dto.MonsterDetailDto
import com.example.dndhandbook.data.remote.dto.MonsterListDto

interface MonsterRepository {
    suspend fun fetchAllMonsters(): MonsterListDto
    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto?
}