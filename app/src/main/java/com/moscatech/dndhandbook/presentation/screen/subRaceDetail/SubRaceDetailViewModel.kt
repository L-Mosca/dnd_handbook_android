package com.moscatech.dndhandbook.presentation.screen.subRaceDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.common.Constants
import com.moscatech.dndhandbook.common.Resource
import com.moscatech.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.moscatech.dndhandbook.domain.useCase.createCharacter.getSubRacesDetail.GetSubRaceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SubRaceDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSubRaceDetailUseCase: GetSubRaceDetailUseCase,
    crashlytics: FirebaseCrashlytics,
) : BaseViewModel(crashlytics) {

    private val _state = mutableStateOf(SubRaceDetailState())
    val state: State<SubRaceDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.SUB_RACE_DETAIL_SCREEN_ARGUMENT)?.let { index ->
            getSubRaceDetail(index)
        }
    }

    private fun getSubRaceDetail(index: String) {
        getSubRaceDetailUseCase(index).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        SubRaceDetailState(subRaceDetail = result.data ?: SubRaceDetail())
                }

                is Resource.Loading -> {
                    _state.value = SubRaceDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = SubRaceDetailState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}