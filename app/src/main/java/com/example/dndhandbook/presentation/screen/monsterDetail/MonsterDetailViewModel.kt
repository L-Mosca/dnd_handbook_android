package com.example.dndhandbook.presentation.screen.monsterDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.useCase.bestiary.getMonster.GetMonsterUseCase
import com.example.dndhandbook.domain.useCase.collection.updateCollectionUseCase.UpdateCollectionUseCase
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
    private val updateCollectionUseCase: UpdateCollectionUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterDetailState())
    val uiState: StateFlow<MonsterDetailState> = _uiState.asStateFlow()

    private var isFromCollection = false
    private var monsterIndex: String
    private var collectionId: Long? = null

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

            getMonsterDetail()
        }
    }

    fun getMonsterDetail() {
        getMonsterDetailUseCase(monsterIndex).onEach { result ->
            when (result) {
                is Resource.Success -> showMonsterDetail(result.data ?: MonsterDetail())
                is Resource.Loading -> showLoading()
                is Resource.Error -> showError()
            }
        }.launchIn(viewModelScope)
    }

    fun saveMonsterDetail(monster: DefaultObject) {
        viewModelScope.launch {
            updateCollectionUseCase.invoke(collectionId, monster)
            _uiState.update { it.copy(navigateBack = true) }
        }
    }

    private fun showMonsterDetail(monsterDetail: MonsterDetail) {
        _uiState.update {
            it.copy(
                monsterDetail = monsterDetail,
                isLoading = false,
                showError = false,
            )
        }
    }

    private fun showLoading() {
        _uiState.update { it.copy(isLoading = true, showError = false, monsterDetail = null) }
    }

    private fun showError() {
        _uiState.update { it.copy(isLoading = false, showError = true, monsterDetail = null) }
    }
}