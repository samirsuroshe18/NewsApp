package `in`.smartdwell.newsapp.domain.usecases.news

import `in`.smartdwell.newsapp.data.local.NewsDao
import `in`.smartdwell.newsapp.domain.model.Article
import `in`.smartdwell.newsapp.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article = article)
    }

}