package com.example.dndhandbook.presentation.screen.monsterList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.useCase.getMonsters.GetMonstersUseCase
import com.example.dndhandbook.navigation.MonsterListRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MonsterListViewModel @Inject constructor(
    private val getMonsterUseCase: GetMonstersUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterListUIState())
    val uiState: StateFlow<MonsterListUIState> = _uiState.asStateFlow()

    private var collectionId = savedStateHandle.toRoute<MonsterListRoute>().id

    init {
        collectionId?.let { id ->
            _uiState.update { it.copy(collectionId = id) }
        }

        getMonsters()
    }

    private fun getMonsters() {
        getMonsterUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let { data ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = "",
                                monsterList = data,
                                filterList = data
                            )
                        }
                    }
                }

                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true, error = "") }
                }

                is Resource.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.message ?: "") }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun filterMonster(query: String) {
        val list = _uiState.value.monsterList.results

        val filteredList = if (query.isBlank()) list
        else list.filter { it.name.contains(query, ignoreCase = true) }

        _uiState.update {
            it.copy(
                filterList = DefaultList(results = filteredList),
                filter = query
            )
        }
    }

}