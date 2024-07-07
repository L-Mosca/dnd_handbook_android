package com.example.dndhandbook.presentation.screen.race_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.race.RaceDetail
import com.example.dndhandbook.domain.use_case.get_race_detail.GetRaceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RaceDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRaceDetailUseCase: GetRaceDetailUseCase
) :
    BaseViewModel() {

    private val _state = mutableStateOf(RaceDetailState())
    val state: State<RaceDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.RACE_DETAIL_SCREEN_ARGUMENT)?.let { index ->
            getRaceDetail(index)
        }
    }


    private fun getRaceDetail(index: String) {
        getRaceDetailUseCase.invoke(index).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        RaceDetailState(raceDetail = result.data ?: RaceDetail())
                }

                is Resource.Loading -> {
                    _state.value = RaceDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = RaceDetailState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}