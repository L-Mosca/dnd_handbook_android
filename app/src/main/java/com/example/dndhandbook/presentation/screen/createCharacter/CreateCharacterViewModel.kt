package com.example.dndhandbook.presentation.screen.createCharacter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.Character
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.useCase.createCharacter.getClasses.GetClassesUseCase
import com.example.dndhandbook.domain.useCase.createCharacter.getRaces.GetRacesUseCase
import com.example.dndhandbook.domain.useCase.createCharacter.getSubRaces.GetSubRacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateCharacterViewModel @Inject constructor(
    private val getRacesUseCase: GetRacesUseCase,
    private val getSubRacesUseCase: GetSubRacesUseCase,
    private val getClassUseCase: GetClassesUseCase,
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
                    _state.value = _state.value.copy(raceList = result.data ?: DefaultList())
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
            Constants.CC_CHOSE_RACE -> updateSelectedRace(data as DefaultObject)
            Constants.CC_CHOSE_SUB_RACE -> {
                updateSelectedSubRace(data as DefaultObject)
            }

            Constants.CC_CHOSE_CLASS -> {}
        }
    }

    fun previewStep() {
        val actualStep = _state.value.step
        val hasSubRaceList = _state.value.subRaceList.results.isNotEmpty()

        val previewStep = when {
            actualStep == Constants.CC_CHOSE_CLASS && !hasSubRaceList -> Constants.CC_CHOSE_RACE
            else -> actualStep - 1
        }

        _state.value = _state.value.copy(step = previewStep)
    }

    private fun updateSelectedRace(race: DefaultObject) {
        val character = _state.value.character ?: Character()
        character.race = race
        _state.value = _state.value.copy(character = character, subRaceList = DefaultList())
        getSubRaceList(race.index)
    }

    private fun updateSelectedSubRace(race: DefaultObject) {
        val character = _state.value.character ?: Character()
        character.subRace = race
        _state.value = _state.value.copy(step = Constants.CC_CHOSE_CLASS, character = character)
        getClassList()
    }

    private fun getSubRaceList(index: String) {
        if (index.isEmpty()) {
            _state.value = _state.value.copy(step = Constants.CC_CHOSE_CLASS)
            getClassList()
        } else {
            getSubRacesUseCase(index).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data?.results?.isEmpty() == true) {
                            nextStep(DefaultObject())
                        } else {
                            _state.value = _state.value.copy(
                                step = Constants.CC_CHOSE_SUB_RACE,
                                subRaceList = result.data ?: DefaultList()
                            )
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
    }

    private fun getClassList() {
        getClassUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        classList = result.data ?: DefaultList(),
                        isLoading = false
                    )
                }

                is Resource.Error -> _state.value =
                    _state.value.copy(error = result.message!!, isLoading = false)

                is Resource.Loading -> _state.value = _state.value.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}