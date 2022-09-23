package com.example.jokesapiapp.domain.repository

import com.example.jokesapiapp.data.remote.JokesDto.JokeDto
import com.example.jokesapiapp.data.remote.JokesDto.JokesDto

interface JokesRepository {

    suspend fun getAllJokes(type: String, amount: String): JokesDto
}