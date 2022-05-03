package com.hci.obtt.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object RepositoryInjector {

    private const val PREFERENCES_NAME = "PREFERENCES_NAME"
    lateinit var application: Application

    fun getPreferences(): SharedPreferences {
        return application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}