package com.example.jokesapiapp.domain.use_case

import com.example.jokesapiapp.data.remote.JokesDto.toJokes
import com.example.jokesapiapp.domain.model.Jokes
import com.example.jokesapiapp.domain.repository.JokesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.io.IOException
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(
    private val repository: JokesRepository
) {
    var list : List<Jokes> = emptyList()                    //resource
    operator fun invoke(type: String, amount: String): Flow<List<Jokes>> = flow {
        try {
            list = repository.getAllJokes(type,amount).jokes.map {jokeDto ->
          jokeDto.toJokes()
          }
            emit(list)

        }catch (e: HttpException){
            emit(list)
        }catch (e: IOException){
            emit(list)
        }
    }
}