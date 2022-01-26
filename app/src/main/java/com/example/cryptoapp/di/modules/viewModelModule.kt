package com.example.cryptoapp.di.modules

import com.example.cryptoapp.ui.coinList.CoinListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CoinListViewModel(get()) }
}