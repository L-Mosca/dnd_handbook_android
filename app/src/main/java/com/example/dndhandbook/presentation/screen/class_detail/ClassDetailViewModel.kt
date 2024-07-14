package com.example.dndhandbook.presentation.screen.class_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.class_detail.ClassDetail
import com.example.dndhandbook.domain.use_case.get_class_detail.GetClassDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ClassDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getClassDetailUseCase: GetClassDetailUseCase
) : BaseViewModel() {

    private val _state = mutableStateOf(ClassDetailState())
    val state: State<ClassDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.CLASS_DETAIL_SCREEN_ARGUMENT)?.let { index ->
            getClassDetail(index)
        }
    }

    private fun getClassDetail(index: String) {
        getClassDetailUseCase.invoke(index).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        _state.value.copy(classDetail = result.data ?: ClassDetail(), isLoading = false)
                }

                is Resource.Loading -> _state.value = _state.value.copy(isLoading = true)

                is Resource.Error -> {
                    _state.value = _state.value.copy(isLoading = false, error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}