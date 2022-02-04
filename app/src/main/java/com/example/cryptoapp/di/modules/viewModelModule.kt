package com.example.cryptoapp.di.modules

import com.example.cryptoapp.ui.detail.DetailViewModel
import com.example.cryptoapp.ui.myCoins.MyCoinsViewModel
import com.example.cryptoapp.ui.overview.OverViewViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { OverViewViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { MyCoinsViewModel(get()) }
}