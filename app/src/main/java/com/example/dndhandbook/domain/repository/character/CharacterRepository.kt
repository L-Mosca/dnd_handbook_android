package com.example.dndhandbook.domain.repository.character


import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.example.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList

interface CharacterRepository {
    suspend fun fetchRaceList(): DefaultList

    suspend fun fetchRaceDetail(index: String): RaceDetailDto

    suspend fun fetchSubRaceDetail(index: String): SubRaceDetailDto

    suspend fun fetchSubRaces(index: String): DefaultList

    suspend fun fetchClasses(): DefaultList
}