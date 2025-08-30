package com.moscatech.dndhandbook.presentation.screen.raceDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.common.Constants
import com.moscatech.dndhandbook.common.Resource
import com.moscatech.dndhandbook.domain.models.race.RaceDetail
import com.moscatech.dndhandbook.domain.useCase.createCharacter.getRaceDetail.GetRaceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RaceDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRaceDetailUseCase: GetRaceDetailUseCase,
    crashlytics: FirebaseCrashlytics,
) : BaseViewModel(crashlytics) {

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