package com.example.jokesapiapp.di

import com.example.jokesapiapp.common.Constants
import com.example.jokesapiapp.data.remote.JokesApi
import com.example.jokesapiapp.domain.repository.JokesRepository
import com.example.jokesapiapp.data.repository.JokesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JokesModul {

    @Provides
    @Singleton
    fun provideJokesApi(): JokesApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokesApi::class.java)
    }

    @Provides
    @Singleton
    fun providePrepository(api: JokesApi): JokesRepository{
        return JokesRepositoryImp(api)
    }
}