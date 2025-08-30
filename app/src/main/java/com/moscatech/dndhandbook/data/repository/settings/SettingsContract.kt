package com.moscatech.dndhandbook.data.repository.settings

import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs

interface SettingsContract {
    suspend fun getConfigs(): SettingsConfigs?
}