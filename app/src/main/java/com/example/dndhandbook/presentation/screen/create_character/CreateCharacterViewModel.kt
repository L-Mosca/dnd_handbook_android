package com.example.dndhandbook.presentation.screen.create_character

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.race.RaceList
import com.example.dndhandbook.domain.use_case.get_races.GetRacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateCharacterViewModel @Inject constructor(private val getRacesUseCase: GetRacesUseCase) :
    BaseViewModel() {

    private val _state = mutableStateOf(CreateCharacterState())
    val state: State<CreateCharacterState> = _state


    init {
        getRaces()
    }

    private fun getRaces() {
        getRacesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CreateCharacterState(raceList = result.data ?: RaceList())
                }

                is Resource.Loading -> {
                    _state.value = CreateCharacterState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = CreateCharacterState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun <T> nextStep(data: T?) {}

    fun <T> previewStep(data: T?) {}
}