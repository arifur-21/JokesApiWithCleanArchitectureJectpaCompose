package com.example.jokesapiapp.presentation

import com.example.jokesapiapp.domain.model.Jokes

data class JokesListState(
    val isLoading : Boolean = false,
    val jokes: List<Jokes> = emptyList(),
    val error: String = ""
)
