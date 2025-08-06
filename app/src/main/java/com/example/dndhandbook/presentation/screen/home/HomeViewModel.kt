package com.example.dndhandbook.presentation.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.domain.useCase.collection.getCollection.GetCollectionUseCase
import com.example.dndhandbook.domain.useCase.collection.getCollections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCollectionsUseCase: GetCollectionsUseCase,
    private val getCollectionUseCase: GetCollectionUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun getList() {
        getCollectionsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(collectionList = resource.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {}
                is Resource.Error -> {
                    Log.e("test", "DEU ERRO: ${resource.message}")
                }
            }
        }.launchIn(viewModelScope)
    }

    /*fun selectCollection(collection: MonsterCollection? = null) {
        getCollectionUseCase.invoke(collection?.id).onEach { result ->
            if (result is Resource.Success) {
                _uiState.update { it.copy(collectionSelected = result.data) }
            }
        }.launchIn(viewModelScope)
    }*/

    fun resetCollection() {
        _uiState.update { it.copy(collectionSelected = null) }
    }
}