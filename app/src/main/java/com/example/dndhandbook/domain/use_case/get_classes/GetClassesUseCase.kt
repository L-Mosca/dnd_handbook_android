package com.example.dndhandbook.domain.use_case.get_classes

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClassesUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke(): Flow<Resource<DefaultList>> = flow {
        try {
            emit(Resource.Loading())
            val classList = repository.fetchClasses()
            emit(Resource.Success(data = classList))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}