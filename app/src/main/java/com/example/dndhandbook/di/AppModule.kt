package com.example.dndhandbook.di

import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.repository.character.CharacterRepository
import com.example.dndhandbook.data.repository.monster.MonsterRepository
import com.example.dndhandbook.data.repository.character.CharacterRepositoryContract
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideMonsterRepository(dndApi: DndApi): MonsterRepositoryContract {
        return MonsterRepository(dndApi)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(dndApi: DndApi): CharacterRepositoryContract {
        return CharacterRepository(dndApi)
    }
}