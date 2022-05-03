package com.hci.obtt

import android.app.Application
import com.hci.obtt.di.RepositoryInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RepositoryInjector.application = this
    }
}