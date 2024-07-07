package com.example.dndhandbook.presentation.screen.sub_race_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.domain.use_case.get_sub_races_detail.GetSubRaceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SubRaceDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSubRaceDetailUseCase: GetSubRaceDetailUseCase
) : BaseViewModel() {

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