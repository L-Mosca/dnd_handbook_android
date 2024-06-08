package com.example.dndhandbook.di

import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.domain.remote.DndApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApiModules {

    @Provides
    @Singleton
    fun provideDndApi(): DndApi = DndApi.newInstance(BuildConfig.BASE_DND_URL)
}