package com.moscatech.dndhandbook.data.repository.settings

import com.moscatech.dndhandbook.data.local.preferences.PreferencesContract
import com.moscatech.dndhandbook.data.remote.firebase.RemoteDatabaseContract
import com.moscatech.dndhandbook.domain.helper.connectivity.ConnectivityContract
import com.moscatech.dndhandbook.domain.models.connectivity.NonAvailableConnectionException
import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val remoteDatabase: RemoteDatabaseContract,
    private val preferencesHelper: PreferencesContract,
    private val connectivityHelper: ConnectivityContract,
) : SettingsContract {

    override suspend fun getConfigs(): SettingsConfigs? {
        val configs = preferencesHelper.getSettingsConfigs()
        if (configs != null) return configs

        if (!connectivityHelper.hasNetworkConnection()) throw NonAvailableConnectionException()

        val configsFromRemoteDb = remoteDatabase.getSettingsConfigs()
        configsFromRemoteDb?.let { preferencesHelper.saveSettingsConfigs(it) }

        return configsFromRemoteDb
    }
}