package com.example.jokesapiapp.data.repository

import com.example.jokesapiapp.data.remote.JokesApi
import com.example.jokesapiapp.data.remote.JokesDto.JokesDto
import com.example.jokesapiapp.domain.repository.JokesRepository
import javax.inject.Inject

class JokesRepositoryImp @Inject constructor(
    private val jokesApi: JokesApi
) : JokesRepository {
    override suspend fun getAllJokes(type: String, amount: String): JokesDto {
      return  jokesApi.getAllJokes(type,amount)
    }


}