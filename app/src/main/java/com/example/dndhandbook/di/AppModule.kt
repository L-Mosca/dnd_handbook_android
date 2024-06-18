package com.example.dndhandbook.di

import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.repository.character.CharacterRepositoryImpl
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryImpl
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import com.example.dndhandbook.domain.repository.monster.MonsterRepository
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
    fun provideMonsterRepository(dndApi: DndApi): MonsterRepository {
        return MonsterRepositoryImpl(dndApi)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(dndApi: DndApi): CharacterRepository {
        return CharacterRepositoryImpl(dndApi)
    }
}