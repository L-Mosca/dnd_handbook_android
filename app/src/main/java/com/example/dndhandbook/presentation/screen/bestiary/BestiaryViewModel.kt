package com.example.dndhandbook.presentation.screen.bestiary

import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.useCase.getMonsters.GetMonstersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BestiaryViewModel @Inject constructor(
    private val getMonstersUseCase: GetMonstersUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(BestiaryState())
    val uiState: StateFlow<BestiaryState> = _uiState.asStateFlow()

    init {
        getMonsters()
    }

    private fun getMonsters() {
        getMonstersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(
                            monsterList = result.data ?: DefaultList(),
                            filterList = result.data ?: DefaultList(),
                            isLoading = false,
                            error = "",
                        )
                    }
                }

                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true, error = "") }
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            error = result.message!!,
                            isLoading = false,
                            monsterList = DefaultList(),
                            filterList = DefaultList(),
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun filterMonster(query: String) {
        val filteredList = if (query.isBlank()) {
            _uiState.value.monsterList.results
        } else {
            _uiState.value.monsterList.results.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }

        _uiState.update { it.copy(filterList = DefaultList(results = filteredList)) }
    }
}