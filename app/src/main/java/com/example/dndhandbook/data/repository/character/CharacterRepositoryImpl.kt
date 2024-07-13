package com.example.dndhandbook.data.repository.character

import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.example.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val dndApi: DndApi) :
    CharacterRepository {

    override suspend fun fetchRaceList(): DefaultList {
        return dndApi.fetchRaceList() ?: DefaultList()
    }

    override suspend fun fetchRaceDetail(index: String): RaceDetailDto {
        return dndApi.fetchRaceDetail(index) ?: RaceDetailDto()
    }

    override suspend fun fetchSubRaceDetail(index: String): SubRaceDetailDto {
        return dndApi.fetchSubRaceDetail(index) ?: SubRaceDetailDto()
    }

    override suspend fun fetchSubRaces(index: String): DefaultList {
        return dndApi.fetchSubRaceList(index) ?: DefaultList()
    }

    override suspend fun fetchClasses(): DefaultList {
        return dndApi.fetchClasses() ?: DefaultList()
    }
}