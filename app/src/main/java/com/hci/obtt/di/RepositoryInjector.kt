package com.hci.obtt.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.hci.obtt.repository.MainRepository
import com.hci.obtt.repository.MainRepositoryImpl

object RepositoryInjector {

    private const val PREFERENCES_NAME = "PREFERENCES_NAME"
    private var mainRepository: MainRepository? = null
    lateinit var application: Application

    fun createMainRepository(): MainRepository {
        return mainRepository ?: MainRepositoryImpl(getPreferences()).apply {
            mainRepository = this
        }
    }

    fun getPreferences(): SharedPreferences {
        return application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}