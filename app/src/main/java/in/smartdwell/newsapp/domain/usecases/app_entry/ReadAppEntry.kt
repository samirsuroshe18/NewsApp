package `in`.smartdwell.newsapp.domain.usecases.app_entry

import `in`.smartdwell.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean>  {
        return localUserManager.readAppEntry()
    }
}