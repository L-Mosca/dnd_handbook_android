package com.example.dndhandbook.presentation.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.useCase.getCollection.GetCollectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCollectionUseCase: GetCollectionUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun getList() {
        getCollectionUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    Log.e("test", "${resource.data}")
                    _uiState.update {
                        it.copy(collectionList = resource.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {}
                is Resource.Error -> {
                    Log.e("test", "DEU ERRO: ${resource.message}")
                }
            }
        }.launchIn(viewModelScope)
    }
}