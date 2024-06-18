package com.example.dndhandbook.domain.repository.character


import com.example.dndhandbook.data.remote.dto.RaceListDto

interface CharacterRepository {
    suspend fun fetchRaceList(): RaceListDto?
}