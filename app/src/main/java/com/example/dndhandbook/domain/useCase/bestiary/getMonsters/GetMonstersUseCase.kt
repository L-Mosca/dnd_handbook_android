package com.example.dndhandbook.domain.useCase.bestiary.getMonsters

import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class GetMonstersUseCase @Inject constructor(private val repository: MonsterRepositoryContract) {

    suspend fun invoke(): DefaultList {
        val monsterList = repository.fetchAllMonsters()
        return monsterList
    }
}