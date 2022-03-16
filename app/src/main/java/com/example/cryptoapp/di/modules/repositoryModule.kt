package com.example.cryptoapp.di.modules

import com.example.cryptoapp.repository.CoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CoinRepository(get(), get()) }
}