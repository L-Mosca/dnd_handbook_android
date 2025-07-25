package com.example.dndhandbook.domain.useCase.getCollection

import androidx.datastore.core.IOException
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCollectionUseCase @Inject constructor(private val repository: CollectionContract) {

    operator fun invoke(): Flow<Resource<List<MonsterCollection>>> = flow {
        try {
            emit(Resource.Loading())
            val list = repository.getCollections()
            emit(Resource.Success(data = list))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}