package com.example.dndhandbook.presentation.screen.monsterList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.useCase.bestiary.getMonsters.GetMonstersUseCase
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

    fun getMonsters() {
        getMonsterUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> addList(result.data ?: DefaultList())
                is Resource.Loading -> showLoading()
                is Resource.Error -> showError()
            }
        }.launchIn(viewModelScope)
    }

    fun filterMonster(query: String) {
        _uiState.update { it.copy(filterText = query) }

        val filteredList = if (query.isBlank()) {
            _uiState.value.monsterList.results
        } else {
            _uiState.value.monsterList.results.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }

        updateFilterList(DefaultList(results = filteredList))
    }

    private fun addList(list: DefaultList) {
        _uiState.update {
            it.copy(
                monsterList = list,
                filterList = list,
                isLoading = false,
                showError = false,
                showEmptyList = false,
            )
        }
    }

    private fun updateFilterList(list: DefaultList) {
        _uiState.update {
            it.copy(
                filterList = list,
                showEmptyList = list.results.isEmpty(),
                showError = false,
                isLoading = false,
            )
        }
    }

    private fun showError() {
        _uiState.update {
            it.copy(
                showEmptyList = false,
                showError = true,
                isLoading = false,
                monsterList = DefaultList(),
                filterList = DefaultList(),
            )
        }
    }

    private fun showLoading() {
        _uiState.update {
            it.copy(
                showEmptyList = false,
                showError = false,
                isLoading = true,
            )
        }
    }

}