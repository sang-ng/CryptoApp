package com.example.cryptoapp.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.remote.dto.toCoin
import com.example.cryptoapp.data.repository.CoinRepository
import com.example.cryptoapp.model.Coin
import kotlinx.coroutines.launch

class OverViewViewModel(
    private val repository: CoinRepository
) : ViewModel() {

    enum class CoinApiStatus { LOADING, ERROR, SUCCESS }

    val status: LiveData<CoinApiStatus>
        get() = _status

    val coins: LiveData<List<Coin>>
        get() = _coins

    private val _status = MutableLiveData<CoinApiStatus>()
    private val _coins = MutableLiveData<List<Coin>>()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _status.value = CoinApiStatus.LOADING

            try {
                _coins.value = repository.getCoins().map { it.toCoin() }
                _status.value = CoinApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = CoinApiStatus.ERROR
                _coins.value = ArrayList()
            }
        }
    }
}
