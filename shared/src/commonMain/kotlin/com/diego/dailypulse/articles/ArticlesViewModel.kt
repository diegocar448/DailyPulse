package com.diego.dailypulse.articles

import com.diego.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init{
        getArticles()
    }

    //fun retornar os artigos
    private fun getArticles(){
        //codigo que executara sem bloquear a thread principal
        scope.launch {
            delay(500)
            _articlesState.emit(ArticlesState())
        }
    }
}