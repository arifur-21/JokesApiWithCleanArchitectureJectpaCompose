package com.example.jokesapiapp.data.remote.JokesDto

import com.example.jokesapiapp.domain.model.Jokes

data class JokeDto(
    val category: String,
    val flags: Flags,
    val id: Int,
    val joke: String,
    val lang: String,
    val safe: Boolean,
    val type: String
)

fun JokeDto.toJokes(): Jokes{
    return Jokes(
        category = category,
        joke = joke,
        lang = lang,
        type = type
    )
}