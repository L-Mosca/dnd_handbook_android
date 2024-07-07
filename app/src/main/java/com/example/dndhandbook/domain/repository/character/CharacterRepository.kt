package com.example.dndhandbook.domain.repository.character


import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.example.dndhandbook.data.remote.dto.race.RaceListDto

interface CharacterRepository {
    suspend fun fetchRaceList(): RaceListDto

    suspend fun fetchRaceDetail(index: String): RaceDetailDto
}