package com.moscatech.dndhandbook.data.repository.monster

import com.moscatech.dndhandbook.data.local.database.BestiaryDao
import com.moscatech.dndhandbook.data.remote.DndApi
import com.moscatech.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.moscatech.dndhandbook.domain.models.BestiaryEntity
import com.moscatech.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class MonsterRepository @Inject constructor(
    private val dndApi: DndApi,
    private val bestiaryDao: BestiaryDao,
) : MonsterRepositoryContract {
    override suspend fun fetchAllMonsters(): DefaultList {
        return bestiaryDao.getBestiary().toDefaultList()
    }

    override suspend fun fetchMonsterDetail(monsterIndex: String): MonsterDetailDto? {
        return dndApi.fetchMonsterDetail(monsterIndex)
    }

    override suspend fun saveAllMonsters() {
        bestiaryDao.clear()
        val data = getAllMonstersFromApi()
        val bestiary = BestiaryEntity(count = data.count, results = data.results)
        bestiaryDao.insertBestiary(bestiary)
    }

    private suspend fun getAllMonstersFromApi(): DefaultList {
        return dndApi.fetchAllMonsters() ?: DefaultList()
    }
}