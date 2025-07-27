package com.example.dndhandbook.domain.useCase.newCollectionUseCase

import android.content.Context
import androidx.datastore.core.IOException
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.domain.models.exception.DuplicateCollectionException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewCollectionUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val collectionRepository: CollectionContract,
) {
    operator fun invoke(collection: MonsterCollection): Flow<Resource<MonsterCollection?>> = flow {
        try {
            emit(Resource.Loading())
            collectionRepository.getCollection(collection.name)?.let {
                throw DuplicateCollectionException()
            }
            collectionRepository.saveCollection(collection)
            emit(Resource.Success(data = collection))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: DuplicateCollectionException) {
            emit(Resource.Error(message = context.getString(e.messageResId)))
        }
    }
}