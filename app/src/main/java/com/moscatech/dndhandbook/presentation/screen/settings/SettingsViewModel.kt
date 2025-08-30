package com.moscatech.dndhandbook.presentation.screen.settings

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.domain.useCase.settings.GetConfigsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getConfigsUseCase: GetConfigsUseCase,
    crashlytics: FirebaseCrashlytics,
) : BaseViewModel(crashlytics) {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        fetchConfigs()
    }

    private fun fetchConfigs() {
        defaultLaunch(
            function = {
                val configs = getConfigsUseCase.invoke()
                _uiState.update { it.setData(configs) }
            },
            loadingStatus = { loadingStatus ->
                _uiState.update { it.setLoading(loadingStatus) }
            },
            exceptionHandler = {
                _uiState.update { it.setError(true) }
            },
        )
    }

    fun reload() {
        fetchConfigs()
    }
}