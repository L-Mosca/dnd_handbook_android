package com.example.dndhandbook.domain.repository.monster

import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.data.remote.dto.monster.MonsterListDto

interface MonsterRepository {
    suspend fun fetchAllMonsters(): MonsterListDto
    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto?
}