package com.example.jokesapiapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapiapp.domain.use_case.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val jokesUseCase: GetJokesUseCase
): ViewModel(){

    private val jokesStateFlow = mutableStateOf(JokesListState())
     var jokesState: State<JokesListState> = jokesStateFlow

    fun getAllJokes(type: String, amount: String){
        viewModelScope.launch {
            jokesUseCase.invoke(type,amount).collect {
                when{
                    it.isEmpty()->{
                        jokesStateFlow.value = JokesListState(false, emptyList(),"Error Occoured")
                    }
                    it.isNotEmpty()->{
                        jokesStateFlow.value = JokesListState(false, it)
                    }
                    else->{
                        jokesStateFlow.value = JokesListState(false,it,"Error")
                    }

                }
            }
        }

    }

}