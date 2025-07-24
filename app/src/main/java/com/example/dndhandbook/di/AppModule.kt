package com.example.dndhandbook.di

import android.content.Context
import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.data.local.PreferencesContract
import com.example.dndhandbook.data.local.PreferencesHelper
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.repository.character.CharacterRepository
import com.example.dndhandbook.data.repository.character.CharacterRepositoryContract
import com.example.dndhandbook.data.repository.monster.MonsterRepository
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDndApi(): DndApi {
        return DndApi.newInstance(BuildConfig.BASE_DND_URL)
    }

    @Provides
    @Singleton
    fun provideMonsterRepository(dndApi: DndApi, preferences: PreferencesContract): MonsterRepositoryContract {
        return MonsterRepository(dndApi, preferences)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(dndApi: DndApi): CharacterRepositoryContract {
        return CharacterRepository(dndApi)
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesContract {
        return PreferencesHelper(context)
    }
}