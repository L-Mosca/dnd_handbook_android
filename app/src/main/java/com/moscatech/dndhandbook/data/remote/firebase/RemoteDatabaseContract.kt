package com.moscatech.dndhandbook.data.remote.firebase

import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs

interface RemoteDatabaseContract {
    suspend fun getSettingsConfigs(): SettingsConfigs?
}