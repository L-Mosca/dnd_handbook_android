package com.example.dndhandbook.presentation.screen.monsterDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.useCase.getMonster.GetMonsterUseCase
import com.example.dndhandbook.navigation.MonsterDetailRoute
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
class MonsterDetailViewModel @Inject constructor(
    private val getMonsterDetailUseCase: GetMonsterUseCase,
    private val monsterRepository: MonsterRepositoryContract,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterDetailState())
    val uiState: StateFlow<MonsterDetailState> = _uiState.asStateFlow()

    private var isFromCollection = false
    private var monsterIndex: String
    private var collectionId: Int? = null

    init {
        savedStateHandle.toRoute<MonsterDetailRoute>().let { args ->
            isFromCollection = args.isFromCollection
            monsterIndex = args.monsterIndex
            collectionId = args.collectionId

            _uiState.update {
                it.copy(
                    isFromCollection = args.isFromCollection,
                    collectionId = args.collectionId,
                )
            }

            getMonsterDetail(args.monsterIndex)
        }
    }

    private fun getMonsterDetail(monsterIndex: String) {
        getMonsterDetailUseCase(monsterIndex).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.update { it.copy(monsterDetail = result.data ?: MonsterDetail()) }
                }

                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }

                is Resource.Error -> {
                    _uiState.update { it.copy(error = result.message!!) }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveMonsterDetail(monster: DefaultObject) {
        viewModelScope.launch {
            monsterRepository.saveMonsterDetail(monster)
            _uiState.update { it.copy(navigateBack = true) }
        }
    }
}