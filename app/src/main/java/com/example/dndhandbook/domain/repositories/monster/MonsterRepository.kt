package com.example.dndhandbook.domain.repositories.monster

import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.models.monster.MonsterList
import com.example.dndhandbook.domain.remote.DndApi
import javax.inject.Inject

class MonsterRepository @Inject constructor(private val api: DndApi) : MonsterRepositoryContract {

    override suspend fun fetchAllMonsters(): MonsterList = api.fetchAllMonsters() ?: MonsterList()

    override suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetail? =
        api.fetchMonsterDetail(monsterIndex)
}