package com.example.dndhandbook.presentation.screen.newCollection

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.useCase.getCollections.GetCollectionsUseCase
import com.example.dndhandbook.domain.useCase.newCollectionUseCase.NewCollectionUseCase
import com.example.dndhandbook.navigation.NewCollectionRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewCollectionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val monsterRepository: MonsterRepositoryContract,
    private val getCollectionsUseCase: GetCollectionsUseCase,
    private val newCollectionUseCase: NewCollectionUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(NewCollectionUIState())
    val uiState: StateFlow<NewCollectionUIState> = _uiState.asStateFlow()

    val collectionId = savedStateHandle.toRoute<NewCollectionRoute>().id

    init {
        collectionId?.let { getCollection(collectionId = it) }
    }

    fun getCollection(collectionId: Int) {
        getCollectionsUseCase.invoke(collectionId).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { collection ->
                        Log.e("test", "nome da coleção: ${collection.name}")
                        _uiState.update {
                            it.copy(collection = collection)
                        }
                    }
                }

                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun getMonster() {
        viewModelScope.launch {
            monsterRepository.getMonsterDetail()?.let { monster ->
                if (_uiState.value.collection.monsterList.contains(monster)) return@let

                val newList = _uiState.value.collection.monsterList.toMutableList()
                newList.add(monster)
                _uiState.update { state ->
                    state.copy(collection = state.collection.copy(monsterList = newList.sortedBy { it.name }))
                }
            }
            monsterRepository.clearMonsterDetail()
        }
    }

    fun deleteMonster(monster: DefaultObject) {

    }

    fun updateCollectionName(name: String) {
        _uiState.update { it.copy(collection = it.collection.copy(name = name)) }
    }

    fun save() {
        newCollectionUseCase.invoke(_uiState.value.collection).onEach { result ->
            when (result) {
                is Resource.Success -> _uiState.update { it.copy(saveSuccess = true) }
                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)
    }
}