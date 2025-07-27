package com.example.dndhandbook.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesHelper @Inject constructor(
    @ApplicationContext context: Context
) : PreferencesContract {

    companion object {
        private const val NAME = "DnD.${BuildConfig.BUILD_TYPE}.${BuildConfig.FLAVOR}"

        private val monsterDetailKey = stringPreferencesKey("monsterDetailKey")
    }

    private val Context.dataStore by preferencesDataStore(name = NAME)
    private val dataStore = context.dataStore


    override suspend fun saveMonsterDetail(monster: DefaultObject?) {
        dataStore.edit { pref ->
            pref[monsterDetailKey] = Gson().toJson(monster)
        }
    }

    override suspend fun getMonsterDetail(): DefaultObject? {
        return dataStore.getData<DefaultObject?>(monsterDetailKey)
    }

    override suspend fun clearMonsterDetail() {
        dataStore.edit { pref ->
            pref.remove(monsterDetailKey)
        }
    }
}

internal suspend inline fun <reified T> DataStore<Preferences>.getData(key: Preferences.Key<String>): T? {
    return runCatching {
        val type = object : TypeToken<T>() {}.type
        this.data
            .catch { exception ->
                if (exception is IOException) emit(emptyPreferences()) else throw exception
            }
            .map { prefs ->
                val json = prefs[key]
                if (json.isNullOrEmpty()) null else Gson().fromJson<T>(json, type)
            }
            .first()
    }.getOrNull()
}