package com.example.dndhandbook.domain.use_case.get_race_detail

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.race.RaceDetail
import com.example.dndhandbook.domain.models.race.toRaceDetail
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRaceDetailUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke(index: String): Flow<Resource<RaceDetail>> = flow {
        try {
            emit(Resource.Loading())
            val raceDetail = repository.fetchRaceDetail(index).toRaceDetail()
            emit(Resource.Success(data = raceDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}