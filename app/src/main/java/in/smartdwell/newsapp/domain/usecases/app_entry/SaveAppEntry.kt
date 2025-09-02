package `in`.smartdwell.newsapp.domain.usecases.app_entry

import `in`.smartdwell.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}