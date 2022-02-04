package com.example.cryptoapp.di.modules

import com.example.cryptoapp.data.database.CoinsDatabaseImp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {

    single { CoinsDatabaseImp.getDatabase(androidApplication()) }
    single { CoinsDatabaseImp.getDatabase(androidApplication()).coinDao }
    single { CoinsDatabaseImp.getDatabase(androidApplication()).coinDetailDao }
}