package com.example.dndhandbook.domain.use_case.get_races

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRacesUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke(): Flow<Resource<DefaultList>> = flow {
        try {
            emit(Resource.Loading())
            val raceList = repository.fetchRaceList()
            emit(Resource.Success(data = raceList))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}