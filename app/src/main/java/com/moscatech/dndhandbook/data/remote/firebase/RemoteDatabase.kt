package com.moscatech.dndhandbook.data.remote.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.snapshots
import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class RemoteDatabase @Inject constructor(
    private val dbReference: DatabaseReference
) : RemoteDatabaseContract {

    override suspend fun getSettingsConfigs(): SettingsConfigs? {
        val raw = dbReference.child("settings").snapshots.first().value
        return SettingsConfigs.fromJson(raw)
    }
}