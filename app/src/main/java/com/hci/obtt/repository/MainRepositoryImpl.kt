package com.hci.obtt.repository

import android.content.SharedPreferences
import android.util.Log
import com.hci.obtt.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepositoryImpl(private val sharedPreferences: SharedPreferences) : MainRepository {

    override fun isUserInfoCorrect(user: User): Flow<Boolean> = flow {
        val userData = sharedPreferences.getString("Users", "") ?: ""

        if (userData.isEmpty()) {
            emit(false)
            return@flow
        }

        Log.d(TAG, "isUserInfoCorrect: $userData")
        userData.split(",").forEach {
            try {
                val (id, pw) = it.split(":")
                if (user.id == id && user.password == pw) {
                    emit(true)
                    return@flow
                }
            } catch (e: Exception) {
                return@forEach
            }
        }

        emit(false)
    }

    override fun checkIdExist(checkId: String): Boolean {
        val userData = sharedPreferences.getString("Users", "") ?: ""

        return userData
            .split(",")
            .map { it.split(":").first() }
            .contains(checkId)
    }

    override fun signUp(user: User) {
        val userData = sharedPreferences.getString("Users", "") ?: ""

        val editor = sharedPreferences.edit()

        editor.putString("Users", "$userData,${user.id}:${user.password}")
        editor.apply()

        user.action?.invoke()
    }

    companion object {

        private const val TAG = "MainRepositoryImpl"

    }
}