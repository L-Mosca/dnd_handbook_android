package com.example.dndhandbook.domain.useCase.createCharacter.getRaceDetail

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.race.RaceDetail
import com.example.dndhandbook.domain.models.race.toRaceDetail
import com.example.dndhandbook.data.repository.character.CharacterRepositoryContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRaceDetailUseCase @Inject constructor(private val repository: CharacterRepositoryContract) {

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