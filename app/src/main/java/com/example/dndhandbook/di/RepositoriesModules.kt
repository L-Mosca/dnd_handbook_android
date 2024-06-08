package com.example.dndhandbook.di

import com.example.dndhandbook.domain.repositories.monster.MonsterRepository
import com.example.dndhandbook.domain.repositories.monster.MonsterRepositoryContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModules {

    @Singleton
    @Binds
    fun bindMonsterRepository(monsterRepository: MonsterRepository): MonsterRepositoryContract
}