package com.example.dndhandbook.data.repository.character

import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.example.dndhandbook.data.remote.dto.race.RaceListDto
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val dndApi: DndApi) :
    CharacterRepository {

    override suspend fun fetchRaceList(): RaceListDto {
        return dndApi.fetchRaceList() ?: RaceListDto()
    }

    override suspend fun fetchRaceDetail(index: String): RaceDetailDto {
        return dndApi.fetchRaceDetail(index) ?: RaceDetailDto()
    }
}