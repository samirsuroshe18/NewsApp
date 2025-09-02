package `in`.smartdwell.newsapp.data.remote.dto

import `in`.smartdwell.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)