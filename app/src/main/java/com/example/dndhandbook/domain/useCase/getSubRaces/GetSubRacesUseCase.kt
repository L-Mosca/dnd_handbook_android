package com.example.dndhandbook.domain.useCase.getSubRaces

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.data.repository.character.CharacterRepositoryContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSubRacesUseCase @Inject constructor(private val repository: CharacterRepositoryContract) {

    operator fun invoke(index: String): Flow<Resource<DefaultList>> = flow {
        try {
            emit(Resource.Loading())
            val subRaceList = repository.fetchSubRaces(index)
            emit(Resource.Success(data = subRaceList))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}