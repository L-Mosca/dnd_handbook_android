package com.moscatech.dndhandbook.presentation.screen.settings

import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs

data class SettingsUiState(
    val showLoading: Boolean = false,
    val configs: SettingsConfigs? = null,
    val showError: Boolean = false,
) {
    fun setLoading(loadingStatus: Boolean) = copy(
        showLoading = loadingStatus,
    )

    fun setError(hasError: Boolean) = copy(
        showError = hasError,
    )

    fun setData(settings: SettingsConfigs?) = copy(
        showLoading = false,
        showError = false,
        configs = settings,
    )
}