package com.example.dndhandbook.domain.useCase.getCollections

import androidx.datastore.core.IOException
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCollectionsUseCase @Inject constructor(private val repository: CollectionContract) {

    operator fun invoke(id: Int): Flow<Resource<MonsterCollection>> = flow {
        try {
            emit(Resource.Loading())
            repository.getCollection(id)?.let {
                emit(Resource.Success(data = it))
            }
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}