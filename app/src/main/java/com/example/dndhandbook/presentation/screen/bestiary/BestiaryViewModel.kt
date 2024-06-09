package com.example.dndhandbook.presentation.screen.bestiary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.commoon.Resource
import com.example.dndhandbook.domain.models.MonsterList
import com.example.dndhandbook.domain.use_case.get_monsters.GetMonstersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BestiaryViewModel @Inject constructor(
    private val getMonstersUseCase: GetMonstersUseCase
) : BaseViewModel() {

    private val _state = mutableStateOf(BestiaryState())
    val state: State<BestiaryState> = _state

    init {
        getMonsters()
    }

    private fun getMonsters() {
        getMonstersUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = BestiaryState(monsterList = result.data ?: MonsterList())
                }
                is Resource.Loading -> {
                    _state.value = BestiaryState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = BestiaryState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}