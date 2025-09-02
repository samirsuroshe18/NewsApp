package `in`.smartdwell.newsapp.presentation.bookmark

import `in`.smartdwell.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
