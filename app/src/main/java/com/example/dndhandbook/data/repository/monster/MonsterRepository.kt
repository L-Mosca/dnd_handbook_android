package com.example.dndhandbook.data.repository.monster

import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class MonsterRepository @Inject constructor(private val dndApi: DndApi) : MonsterRepositoryContract {
    override suspend fun fetchAllMonsters(): DefaultList {
        return dndApi.fetchAllMonsters() ?: DefaultList()
    }

    override suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto? {
        return dndApi.fetchMonsterDetail(monsterIndex)
    }
}