package com.example.dndhandbook.presentation.screen.newCollection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.domain.useCase.getCollections.GetCollectionsUseCase
import com.example.dndhandbook.domain.useCase.newCollectionUseCase.NewCollectionUseCase
import com.example.dndhandbook.domain.useCase.updateCollectionUseCase.UpdateCollectionUseCase
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
    private val collectionRepository: CollectionContract,
    private val getCollectionsUseCase: GetCollectionsUseCase,
    private val newCollectionUseCase: NewCollectionUseCase,
    private val updateCollectionUseCase: UpdateCollectionUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(NewCollectionUIState())
    val uiState: StateFlow<NewCollectionUIState> = _uiState.asStateFlow()

    val collectionName = savedStateHandle.toRoute<NewCollectionRoute>().collectionName

    init {
        getCollection(collectionName = collectionName)
    }

    fun getCollection(collectionName: String) {
        getCollectionsUseCase.invoke(collectionName).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { collection ->
                        _uiState.update {
                            it.copy(
                                collectionName = collection.name,
                                monsterList = collection.monsterList,
                            )
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
                if (_uiState.value.monsterList.contains(monster)) return@let

                val newList = _uiState.value.monsterList.toMutableList()
                newList.add(monster)
                _uiState.update { state ->
                    state.copy(monsterList = newList.sortedBy { it.name })
                }
            }
            monsterRepository.clearMonsterDetail()
        }
    }

    fun deleteMonster(monster: DefaultObject) {
        val newList = _uiState.value.monsterList.toMutableList()
        newList.remove(monster)
        _uiState.update { it.copy(monsterList = newList) }
    }

    fun updateCollectionName(name: String) {
        _uiState.update { it.copy(collectionName = name) }
    }

    fun save() {
        val collectionData = MonsterCollection(
            name = _uiState.value.collectionName,
            monsterList = _uiState.value.monsterList,
        )

        if (collectionName.isBlank()) {
            newCollectionUseCase.invoke(collectionData).onEach { result ->
                when (result) {
                    is Resource.Success -> _uiState.update { it.copy(saveSuccess = true) }
                    is Resource.Loading -> {}
                    is Resource.Error -> {}
                }
            }.launchIn(viewModelScope)
        } else {
            updateCollectionUseCase.invoke(collectionData).onEach { result ->
                when (result) {
                    is Resource.Success -> _uiState.update { it.copy(saveSuccess = true) }
                    is Resource.Loading -> {}
                    is Resource.Error -> {}
                }
            }.launchIn(viewModelScope)
        }
    }
}