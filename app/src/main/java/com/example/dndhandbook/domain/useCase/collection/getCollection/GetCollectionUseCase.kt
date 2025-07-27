package com.example.dndhandbook.domain.useCase.collection.getCollection

import androidx.datastore.core.IOException
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCollectionUseCase @Inject constructor(private val repository: CollectionContract) {

    operator fun invoke(id: Long?): Flow<Resource<MonsterCollection>> = flow {
        try {
            emit(Resource.Loading())

            if (id == null) {
                repository.saveCollection(MonsterCollection())?.let { newId ->
                    repository.getCollection(newId)?.let {
                        emit(Resource.Success(data = it))
                    }
                }
            }

            id?.let { id ->
                repository.getCollection(id)?.let {
                    emit(Resource.Success(data = it))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}