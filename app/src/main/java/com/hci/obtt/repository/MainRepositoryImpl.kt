package com.hci.obtt.repository

import android.content.SharedPreferences
import com.hci.obtt.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val sharedPreferences: SharedPreferences) : MainRepository {

    override fun isUserInfoCorrect(user: User): Flow<Boolean> = flow {
        val userData = sharedPreferences.getStringSet("Users", setOf()) as Set<String>

        userData.forEach {
            val (id, pw) = it.split(":")

            if (user.id == id && user.password == pw) {
                emit(true)
                return@flow
            }
        }

        emit(false)
    }

}