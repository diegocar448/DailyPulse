package com.diego.dailypulse.articles

import com.diego.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init{
        getArticles()
    }

    //fun retornar os artigos
    private fun getArticles(){
        //codigo que executara sem bloquear a thread principal
        scope.launch {
            val fetchedArticles = fetchArticles()

            delay(500)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }



    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            "2023-11-09",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpg"
        ),
        Article(
            "Best Iphone Deals (2023): Carrier Deals, Unlocked iPhones",
            "Apple's smartphone rarely go on sale, but if you're looking to upgrade (or you're gift shopping), here.",
            "2023-11-09",
            imageUrl = "https://media.craiyon.com/2023-10-21/1f1d408dddce4984a689afc06d9f42d8.webp"
        ),
        Article(
            "What is Lorem Ipsum?",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
            "2023-11-09",
            imageUrl = "https://imagen.research.google/main_gallery_images/a-robot-couple-fine-dining.jpg"
        ),
    )
}