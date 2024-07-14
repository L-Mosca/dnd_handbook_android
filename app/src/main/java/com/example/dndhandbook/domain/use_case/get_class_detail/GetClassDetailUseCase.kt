package com.example.dndhandbook.domain.use_case.get_class_detail

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.class_detail.ClassDetail
import com.example.dndhandbook.domain.models.class_detail.toClassDetail
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClassDetailUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke(index: String): Flow<Resource<ClassDetail>> = flow {
        try {
            emit(Resource.Loading())
            val classDetail = repository.fetchClassDetail(index).toClassDetail()
            emit(Resource.Success(data = classDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}