package com.example.cryptoapp.ui.myCoins

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.repository.CoinRepository

class MyCoinsViewModel(private val repository: CoinRepository) : ViewModel() {

    fun getMyCoins() = repository.getSavedCoins()

}