package com.example.cryptoapp.presentation.ui.coinList

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.useCase.getCoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinUseCase
) : ViewModel() {


}