package com.hci.obtt.ui.tab

import androidx.lifecycle.ViewModel
import com.hci.obtt.di.RepositoryInjector
import com.hci.obtt.repository.HomeRepository

class TabViewModel : ViewModel() {

    private val repository: HomeRepository = RepositoryInjector.createHomeRepository()

    suspend fun getVideoData() = repository.getVideoData()
}