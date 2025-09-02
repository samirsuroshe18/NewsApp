package `in`.smartdwell.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import `in`.smartdwell.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to News App",
        description = "Discover a simple way to manage everything in one place.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Organized",
        description = "Keep track of tasks, progress, and goals effortlessly.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Connect & Grow",
        description = "Stay updated and connected anytime, anywhere.",
        image = R.drawable.onboarding3
    )
)