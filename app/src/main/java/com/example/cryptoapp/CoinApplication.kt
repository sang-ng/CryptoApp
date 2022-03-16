package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.di.modules.databaseModule
import com.example.cryptoapp.di.modules.networkModule
import com.example.cryptoapp.di.modules.repositoryModule
import com.example.cryptoapp.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoinApplication)
            modules(repositoryModule, viewModelModule, databaseModule, networkModule)
        }
    }
}