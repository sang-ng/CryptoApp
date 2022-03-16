package com.example.cryptoapp.di.modules

import com.example.cryptoapp.data.remote.provideNetworkApi
import com.example.cryptoapp.data.remote.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    single { provideRetrofit() }
    single { provideNetworkApi(get()) }
}

