package com.example.dndhandbook.presentation.screen.monsterDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.useCase.bestiary.getMonster.GetMonsterUseCase
import com.example.dndhandbook.navigation.MonsterDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MonsterDetailViewModel @Inject constructor(
    private val getMonsterDetailUseCase: GetMonsterUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterDetailState())
    val uiState: StateFlow<MonsterDetailState> = _uiState.asStateFlow()

    private var isFromCollection = false
    private var monsterIndex: String

    init {
        savedStateHandle.toRoute<MonsterDetailRoute>().let { args ->
            isFromCollection = args.isFromCollection
            monsterIndex = args.monsterIndex

            _uiState.update {
                it.copy(isFromCollection = args.isFromCollection)
            }

            getMonsterDetail()
        }
    }

    fun getMonsterDetail() {
        getMonsterDetailUseCase(monsterIndex).onEach { result ->
            when (result) {
                is Resource.Success -> _uiState.update { it.setMonsterDetail(result.data) }
                is Resource.Loading -> _uiState.update { it.showLoading() }
                is Resource.Error -> _uiState.update { it.showError() }
            }
        }.launchIn(viewModelScope)
    }
}