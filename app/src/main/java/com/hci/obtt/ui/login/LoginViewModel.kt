package com.hci.obtt.ui.login

import androidx.lifecycle.ViewModel
import com.hci.obtt.di.RepositoryInjector
import com.hci.obtt.repository.MainRepository

class LoginViewModel : ViewModel() {

    private val repository: MainRepository = RepositoryInjector.createMainRepository()
}