package com.example.dndhandbook.domain.repositories.monster

import com.example.dndhandbook.domain.remote.DndApi
import javax.inject.Inject

class MonsterRepository @Inject constructor(private val api: DndApi) : MonsterRepositoryContract {
}