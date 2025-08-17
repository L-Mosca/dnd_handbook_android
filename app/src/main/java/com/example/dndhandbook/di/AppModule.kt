package com.example.dndhandbook.di

import android.content.Context
import androidx.room.Room
import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.data.local.database.AppDatabase
import com.example.dndhandbook.data.local.database.BestiaryDao
import com.example.dndhandbook.data.local.database.CollectionsDao
import com.example.dndhandbook.data.local.preferences.PreferencesContract
import com.example.dndhandbook.data.local.preferences.PreferencesHelper
import com.example.dndhandbook.data.remote.DndApi
import com.example.dndhandbook.data.repository.character.CharacterRepository
import com.example.dndhandbook.data.repository.character.CharacterRepositoryContract
import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.data.repository.collection.CollectionRepository
import com.example.dndhandbook.data.repository.monster.MonsterRepository
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import com.example.dndhandbook.domain.helper.connectivity.ConnectivityContract
import com.example.dndhandbook.domain.helper.connectivity.ConnectivityHelper
import com.example.dndhandbook.domain.helper.file.FileContract
import com.example.dndhandbook.domain.helper.file.FileHelper
import com.example.dndhandbook.domain.helper.pdf.PDFContract
import com.example.dndhandbook.domain.helper.pdf.PDFHelper
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
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "dnd-database-${BuildConfig.FLAVOR}-${BuildConfig.BUILD_TYPE}"
    ).build()

    @Provides
    @Singleton
    fun provideCollectionDao(appDatabase: AppDatabase): CollectionsDao = appDatabase.collectionDao()

    @Provides
    @Singleton
    fun provideBestiaryDao(appDatabase: AppDatabase): BestiaryDao = appDatabase.bestiaryDao()

    @Provides
    @Singleton
    fun provideMonsterRepository(
        dndApi: DndApi,
        bestiaryDao: BestiaryDao
    ): MonsterRepositoryContract {
        return MonsterRepository(dndApi, bestiaryDao)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(dndApi: DndApi): CharacterRepositoryContract {
        return CharacterRepository(dndApi)
    }

    @Provides
    @Singleton
    fun provideCollectionRepository(
        collectionsDao: CollectionsDao
    ): CollectionContract {
        return CollectionRepository(
            collectionsDao = collectionsDao,
        )
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesContract {
        return PreferencesHelper(context)
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivityHelper(
        @ApplicationContext context: Context
    ): ConnectivityContract = ConnectivityHelper(context)

    @Provides
    @Singleton
    fun provideFileHelper(
        @ApplicationContext context: Context
    ): FileContract = FileHelper(context)

    @Provides
    @Singleton
    fun providePDFHelper(
        @ApplicationContext context: Context
    ): PDFContract = PDFHelper(context)
}