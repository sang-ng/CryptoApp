package com.example.cryptoapp.di.modules

import com.example.cryptoapp.ui.coinList.OverViewViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { OverViewViewModel(get()) }
}