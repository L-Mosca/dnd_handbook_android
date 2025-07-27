package com.example.dndhandbook.domain.useCase.updateCollectionUseCase

import android.content.Context
import androidx.datastore.core.IOException
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.domain.models.exception.NotFoundCollectionException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract,
    @ApplicationContext private val context: Context,
) {
    operator fun invoke(collection: MonsterCollection): Flow<Resource<MonsterCollection?>> = flow {
        try {
            emit(Resource.Loading())
            val savedCollection = collectionRepository.getCollection(collection.name)

            if (savedCollection == null) throw NotFoundCollectionException()

            collectionRepository.deleteCollection(savedCollection)
            collectionRepository.saveCollection(collection)
            emit(Resource.Success(data = collection))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: NotFoundCollectionException) {
            emit(Resource.Error(message = context.getString(e.messageResId)))
        }
    }
}