package com.example.dndhandbook.presentation.screen.monsterList

import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.useCase.bestiary.getMonsters.GetMonstersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MonsterListViewModel @Inject constructor(
    private val getMonsterUseCase: GetMonstersUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterListUIState())
    val uiState: StateFlow<MonsterListUIState> = _uiState.asStateFlow()

    init {
        getMonsters()
    }

    fun getMonsters() {
        defaultLaunch(
            loadingStatus = { isLoading ->
                if (isLoading) _uiState.update { it.showLoading() }
            },
            exceptionHandler = { _uiState.update { it.showError() } },
            function = { _uiState.update { it.addList(getMonsterUseCase.invoke()) } },
        )
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

        _uiState.update { it.updateFilterList(DefaultList(results = filteredList)) }
    }
}