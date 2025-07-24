package com.example.dndhandbook.presentation.screen.newCollection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.models.base.DefaultObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewCollectionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val monsterRepository: MonsterRepositoryContract,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(NewCollectionUIState())
    val uiState: StateFlow<NewCollectionUIState> = _uiState.asStateFlow()

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
}