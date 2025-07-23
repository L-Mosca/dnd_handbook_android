package com.example.dndhandbook.presentation.screen.monsterDetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.useCase.getMonster.GetMonsterUseCase
import com.example.dndhandbook.navigation.MonsterDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MonsterDetailViewModel @Inject constructor(
    private val getMonsterDetailUseCase: GetMonsterUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _state = mutableStateOf(MonsterDetailState())
    val state: State<MonsterDetailState> = _state

    private var isFromCollection = false
    private var monsterIndex: String

    init {
        savedStateHandle.toRoute<MonsterDetailRoute>().let {
            isFromCollection = it.isFromCollection
            monsterIndex = it.monsterIndex

            Log.e("test", "veio da coleção: $isFromCollection")
            _state.value = _state.value.copy(isFromCollection = isFromCollection)

            getMonsterDetail(it.monsterIndex)
        }
    }

    private fun getMonsterDetail(monsterIndex: String) {
        getMonsterDetailUseCase(monsterIndex).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        MonsterDetailState(monsterDetail = result.data ?: MonsterDetail())
                }

                is Resource.Loading -> {
                    _state.value = MonsterDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MonsterDetailState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}