package `in`.smartdwell.newsapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.smartdwell.newsapp.domain.usecases.app_entry.AppEntryUseCases
import `in`.smartdwell.newsapp.presentation.nvgraph.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    var splashCondition = mutableStateOf(true)
        private set

    var startDestination = mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                startDestination.value = Route.NewsNavigation.route
            }else{
                startDestination.value = Route.AppStartNavigation.route
            }
            delay(300) //Without this delay, the onBoarding screen will show for a momentum.
            splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}