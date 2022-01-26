package com.example.cryptoapp.di.modules

import com.example.cryptoapp.data.repository.CoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CoinRepository() }
}