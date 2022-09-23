package com.example.jokesapiapp.data.remote.JokesDto

data class JokesDto(
    val amount: Int,
    val error: Boolean,
    val jokes: List<JokeDto>
)