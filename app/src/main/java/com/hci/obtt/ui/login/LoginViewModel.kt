package com.hci.obtt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hci.obtt.di.RepositoryInjector
import com.hci.obtt.model.User
import com.hci.obtt.repository.MainRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository: MainRepository = RepositoryInjector.createMainRepository()

    private val _userFlow = MutableSharedFlow<Boolean>(replay = 0)
    val userFlow: SharedFlow<Boolean> = _userFlow

    val id = MutableLiveData("")
    val password = MutableLiveData("")

    fun isIdAndPasswordNotEmpty(): Boolean {
        return (id.value?.isNotEmpty() ?: return false) && (password.value?.isNotEmpty()
            ?: return false)
    }

    fun checkUserInfo() {
        val user = User(id.value ?: "", password.value ?: "")
        viewModelScope.launch {
            repository.isUserInfoCorrect(user).collectLatest {
                _userFlow.emit(it)
            }
        }
    }
}
