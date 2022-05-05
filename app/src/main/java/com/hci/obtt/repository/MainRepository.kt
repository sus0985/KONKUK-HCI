package com.hci.obtt.repository

import com.hci.obtt.model.User
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun isUserInfoCorrect(user: User): Flow<Boolean>
    fun checkIdExist(checkId: String): Boolean
    fun signUp(user: User)
}