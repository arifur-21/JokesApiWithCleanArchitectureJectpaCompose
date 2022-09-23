package com.example.jokesapiapp.data.remote

import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.jokesapiapp.data.remote.JokesDto.JokeDto
import com.example.jokesapiapp.data.remote.JokesDto.JokesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {

    @GET("joke/Any?")
    suspend fun getAllJokes(
        @Query("type") type: String,
        @Query("amount") amount: String
    ): JokesDto
}