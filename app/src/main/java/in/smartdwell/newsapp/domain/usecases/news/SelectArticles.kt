package `in`.smartdwell.newsapp.domain.usecases.news

import `in`.smartdwell.newsapp.data.local.NewsDao
import `in`.smartdwell.newsapp.domain.model.Article
import `in`.smartdwell.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

    operator fun invoke() : Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}