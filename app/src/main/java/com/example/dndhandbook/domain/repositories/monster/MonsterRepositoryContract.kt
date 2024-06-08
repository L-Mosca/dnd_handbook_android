package com.example.dndhandbook.domain.repositories.monster

import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.models.monster.MonsterList

interface MonsterRepositoryContract {

    suspend fun fetchAllMonsters(): MonsterList

    suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetail?
}