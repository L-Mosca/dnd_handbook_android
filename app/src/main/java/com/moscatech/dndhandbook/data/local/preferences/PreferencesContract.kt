package com.moscatech.dndhandbook.data.local.preferences

import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs

interface PreferencesContract {
    suspend fun saveSettingsConfigs(configs: SettingsConfigs)
    suspend fun getSettingsConfigs(): SettingsConfigs?
}