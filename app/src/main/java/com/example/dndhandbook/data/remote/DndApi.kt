package com.example.dndhandbook.data.remote

import com.example.dndhandbook.BuildConfig
import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.example.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.remote.ApiConstants
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface DndApi {
    companion object {
        fun newInstance(url: String): DndApi {
            val okHttpClient = getOkHttpClient()
            val retrofit = getRetrofit(okHttpClient, url)
            return retrofit.create(DndApi::class.java)
        }

        private fun getRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl(url)
                .build()
        }

        private fun getOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE

            return OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    var newRequest = chain.request()
                    newRequest = newRequest.newBuilder().build()
                    chain.proceed(newRequest)
                }
                .build()
        }
    }

    @GET(ApiConstants.FETCH_MONSTERS)
    suspend fun fetchAllMonsters(): DefaultList?

    @GET(ApiConstants.FETCH_MONSTER_DETAIL)
    suspend fun fetchMonsterDetail(@Path("index") monsterIndex: String): MonsterDetailDto?

    @GET(ApiConstants.FETCH_RACE_LIST)
    suspend fun fetchRaceList(): DefaultList?

    @GET("${ApiConstants.FETCH_RACE_LIST}/{index}")
    suspend fun fetchRaceDetail(@Path("index") raceIndex: String): RaceDetailDto?

    @GET(ApiConstants.FETCH_SUB_RACE_DETAIL)
    suspend fun fetchSubRaceDetail(@Path("index") subRaceIndex: String): SubRaceDetailDto?

    @GET(ApiConstants.FETCH_SUB_RACE)
    suspend fun fetchSubRaceList(@Path("index") raceIndex: String): DefaultList?

    @GET(ApiConstants.FETCH_CLASSES)
    suspend fun fetchClasses() : DefaultList?

    @GET(ApiConstants.FETCH_CLASS_DETAIL)
    suspend fun fetchClassDetail(@Path("index") classIndex: String): Any?
}