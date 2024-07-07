package com.example.dndhandbook.presentation.screen.create_character

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.Character
import com.example.dndhandbook.domain.models.race.RaceBasicData
import com.example.dndhandbook.domain.models.race.RaceList
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.domain.use_case.get_races.GetRacesUseCase
import com.example.dndhandbook.domain.use_case.get_sub_races.GetSubRacesUseCase
import com.example.dndhandbook.domain.use_case.get_sub_races_detail.GetSubRaceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateCharacterViewModel @Inject constructor(
    private val getRacesUseCase: GetRacesUseCase,
    private val getSubRacesUseCase: GetSubRacesUseCase,
    private val getSubRaceDetailUseCase: GetSubRaceDetailUseCase
) :
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
                    _state.value = _state.value.copy(raceList = result.data ?: RaceList())
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun <T> nextStep(data: T?) {
        when (_state.value.step) {
            Constants.CC_CHOSE_RACE -> updateSelectedRace(data as RaceBasicData)
            Constants.CC_CHOSE_SUB_RACE -> {
                updateSelectedSubRace(data as RaceBasicData)
            }

            Constants.CC_CHOSE_CLASS -> {}
        }
    }

    fun <T> previewStep(data: T?) {
        val actualStep = _state.value.step
        _state.value = _state.value.copy(step = actualStep - 1)
    }

    private fun updateSelectedRace(race: RaceBasicData) {
        val character = _state.value.character ?: Character()
        character.race = race
        _state.value =
            _state.value.copy(step = Constants.CC_CHOSE_SUB_RACE, character = character)
        getSubRaceList(race.index)
    }

    private fun updateSelectedSubRace(race: RaceBasicData) {
        val character = _state.value.character ?: Character()
        character.subRace = race
        _state.value = _state.value.copy(step = Constants.CC_CHOSE_CLASS, character = character)
    }

    private fun getSubRaceList(index: String) {
        getSubRacesUseCase(index).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(subRaceList = result.data ?: RaceList())
                    if (result.data?.results?.isEmpty() == true) {
                        nextStep(RaceBasicData())
                    }
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSubRaceDetail(index: String) {
        getSubRaceDetailUseCase(index).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(subRaceDetail = result.data ?: SubRaceDetail())
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}