package com.moscatech.dndhandbook.domain.useCase.bestiary.getMonsters

import com.moscatech.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.moscatech.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class GetMonstersUseCase @Inject constructor(private val repository: MonsterRepositoryContract) {

    suspend fun invoke(): DefaultList {
        return repository.fetchAllMonsters().apply {
            if (results.isNotEmpty()) return@apply
            repository.saveAllMonsters()
            repository.fetchAllMonsters()
        }
    }
}