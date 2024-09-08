package com.example.dndhandbook.presentation.screen.monster_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.use_case.get_monster.GetMonsterUseCase
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


    init {
        savedStateHandle.get<String>(Constants.MONSTER_DETAIL_SCREEN_ARGUMENT)
            ?.let { monsterIndex ->
                getMonsterDetail(monsterIndex)
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