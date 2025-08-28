package com.moscatech.dndhandbook.data.repository.character

import com.moscatech.dndhandbook.data.remote.DndApi
import com.moscatech.dndhandbook.data.remote.dto.class_detail.ClassDetailDto
import com.moscatech.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.moscatech.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.moscatech.dndhandbook.domain.models.base.DefaultList
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val dndApi: DndApi) :
    CharacterRepositoryContract {

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

    override suspend fun fetchClassDetail(index: String): ClassDetailDto {
        return dndApi.fetchClassDetail(index) ?: ClassDetailDto()
    }
}