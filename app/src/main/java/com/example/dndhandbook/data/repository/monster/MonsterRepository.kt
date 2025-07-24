package com.example.dndhandbook.data.repository.monster

import com.example.dndhandbook.data.local.PreferencesContract
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.models.base.DefaultObject
import javax.inject.Inject

class MonsterRepository @Inject constructor(
    private val dndApi: DndApi,
    private val preferencesHelper: PreferencesContract,
) : MonsterRepositoryContract {
    override suspend fun fetchAllMonsters(): DefaultList {
        return dndApi.fetchAllMonsters() ?: DefaultList()
    }

    override suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto? {
        return dndApi.fetchMonsterDetail(monsterIndex)
    }

    override suspend fun saveMonsterDetail(monster: DefaultObject?) {
        preferencesHelper.saveMonsterDetail(monster)
    }

    override suspend fun getMonsterDetail(): DefaultObject? {
        return preferencesHelper.getMonsterDetail()
    }

    override suspend fun clearMonsterDetail() {
        preferencesHelper.clearMonsterDetail()
    }
}