package `in`.smartdwell.newsapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.smartdwell.newsapp.data.local.NewsDao
import `in`.smartdwell.newsapp.data.local.NewsDatabase
import `in`.smartdwell.newsapp.data.local.NewsTypeConvertor
import `in`.smartdwell.newsapp.data.manager.LocalUserMangerImpl
import `in`.smartdwell.newsapp.data.remote.NewsApi
import `in`.smartdwell.newsapp.data.repository.NewsRepositoryImpl
import `in`.smartdwell.newsapp.domain.manager.LocalUserManager
import `in`.smartdwell.newsapp.domain.repository.NewsRepository
import `in`.smartdwell.newsapp.domain.usecases.app_entry.AppEntryUseCases
import `in`.smartdwell.newsapp.domain.usecases.app_entry.ReadAppEntry
import `in`.smartdwell.newsapp.domain.usecases.app_entry.SaveAppEntry
import `in`.smartdwell.newsapp.domain.usecases.news.DeleteArticle
import `in`.smartdwell.newsapp.domain.usecases.news.GetNews
import `in`.smartdwell.newsapp.domain.usecases.news.NewsUseCases
import `in`.smartdwell.newsapp.domain.usecases.news.SearchNews
import `in`.smartdwell.newsapp.domain.usecases.news.SelectArticle
import `in`.smartdwell.newsapp.domain.usecases.news.SelectArticles
import `in`.smartdwell.newsapp.domain.usecases.news.UpsertArticle
import `in`.smartdwell.newsapp.util.Constants
import `in`.smartdwell.newsapp.util.Constants.NEWS_DATABASE_NAME
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  //This is going to make sure that the dependencies live as long as application is live
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserMangerImpl(application) //Kotlin allows you to skip the curly braces and return keyword when your function returns a single expression.

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}