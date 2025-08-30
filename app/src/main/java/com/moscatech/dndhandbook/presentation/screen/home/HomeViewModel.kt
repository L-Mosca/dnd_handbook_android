package com.moscatech.dndhandbook.presentation.screen.home

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.domain.useCase.collection.getCollections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCollectionsUseCase: GetCollectionsUseCase,
    crashlytics: FirebaseCrashlytics,
) : BaseViewModel(crashlytics) {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun getList() {
        defaultLaunch(
            loadingStatus = {},
            exceptionHandler = {},
            function = {
                _uiState.update { it.setCollectionList(getCollectionsUseCase.invoke()) }
            }
        )
    }
}