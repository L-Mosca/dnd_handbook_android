package com.example.dndhandbook.data.repository.monster

import com.example.dndhandbook.data.local.database.BestiaryDao
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.BestiaryEntity
import com.example.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class MonsterRepository @Inject constructor(
    private val dndApi: DndApi,
    private val bestiaryDao: BestiaryDao,
) : MonsterRepositoryContract {
    override suspend fun fetchAllMonsters(): DefaultList {
        return dndApi.fetchAllMonsters() ?: DefaultList()
    }

    override suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto? {
        return dndApi.fetchMonsterDetail(monsterIndex)
    }

    override suspend fun saveAllMonsters() {
        bestiaryDao.clear()
        val data = fetchAllMonsters()
        val bestiary = BestiaryEntity(count = data.count, results = data.results)
        bestiaryDao.insertBestiary(bestiary)
    }
}