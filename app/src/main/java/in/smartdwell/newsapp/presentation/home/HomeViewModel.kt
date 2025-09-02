package `in`.smartdwell.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.smartdwell.newsapp.domain.usecases.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "cricket", "india")
    ).cachedIn(viewModelScope)
}