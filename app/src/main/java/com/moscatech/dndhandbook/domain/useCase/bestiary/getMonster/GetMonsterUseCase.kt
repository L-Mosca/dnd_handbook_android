package com.moscatech.dndhandbook.domain.useCase.bestiary.getMonster

import com.moscatech.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.moscatech.dndhandbook.domain.models.monster.MonsterDetail
import com.moscatech.dndhandbook.domain.models.monster.toMonsterDetail
import javax.inject.Inject

class GetMonsterUseCase @Inject constructor(private val repository: MonsterRepositoryContract) {

    suspend fun invoke(monsterIndex: String): MonsterDetail {
        val data = repository.fetchMonsterDetail(monsterIndex)?.toMonsterDetail()
        return data ?: MonsterDetail()
    }
}