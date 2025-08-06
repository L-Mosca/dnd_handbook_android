package com.example.dndhandbook.presentation.screen.newCollection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.useCase.collection.deleteCollectionUseCase.DeleteCollectionUseCase
import com.example.dndhandbook.domain.useCase.collection.getCollection.GetCollectionUseCase
import com.example.dndhandbook.domain.useCase.collection.updateCollectionUseCase.UpdateCollectionUseCase
import com.example.dndhandbook.navigation.NewCollectionRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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
    private val getCollectionUseCase: GetCollectionUseCase,
    private val deleteCollectionUseCase: DeleteCollectionUseCase,
    private val updateCollectionUseCase: UpdateCollectionUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(NewCollectionUIState())
    val uiState: StateFlow<NewCollectionUIState> = _uiState.asStateFlow()

    private val collectionId = savedStateHandle.toRoute<NewCollectionRoute>().id

    fun getCollection() {
        /*getCollectionUseCase.invoke(collectionId).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { collection ->
                        _uiState.update { it.copy(collection = collection) }
                    }
                }

                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)*/
    }

    fun deleteMonster(monster: DefaultObject) {
        viewModelScope.launch {
            val list = _uiState.value.collection.monsterList?.toMutableList()
            list?.remove(monster)
            val newData = _uiState.value.collection.copy(monsterList = list)
            updateCollectionUseCase.invoke(newData)
            _uiState.update { it.copy(collection = newData) }
        }
    }

   /* fun updateCollectionName(name: String) {
        val newData = _uiState.value.collection.copy(name = name)
        _uiState.update { it.copy(collection = newData) }
        viewModelScope.launch {
            delay(1000)
            updateCollectionUseCase.invoke(newData)
        }
    }*/

    /*fun deleteCollection() {
        viewModelScope.launch {
            deleteCollectionUseCase.invoke(collectionId)
            _uiState.update { it.copy(saveSuccess = true) }
        }
    }*/

    /*fun deleteIfIsEmpty() {
        if (_uiState.value.collection.isEmpty()) {
            deleteCollection()
        } else {
            _uiState.update { it.copy(saveSuccess = true) }
        }
    }*/
}