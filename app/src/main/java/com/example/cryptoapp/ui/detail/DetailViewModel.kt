package com.example.cryptoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.remote.dto.toCoin
import com.example.cryptoapp.data.remote.dto.toCoinDetail
import com.example.cryptoapp.repository.CoinRepository
import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.model.CoinDetail
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: CoinRepository
) : ViewModel() {

    enum class CoinApiStatus { LOADING, ERROR, SUCCESS }

    val status: LiveData<CoinApiStatus>
        get() = _status

    val coin: LiveData<CoinDetail>
        get() = _coin

    private val _status = MutableLiveData<CoinApiStatus>()
    private val _coin = MutableLiveData<CoinDetail>()


    fun getCoinById(coindId: String) {
        viewModelScope.launch {
            _status.value = CoinApiStatus.LOADING

            try {
                _coin.value = repository.getCoinById(coindId).toCoinDetail()
                _status.value = CoinApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = CoinApiStatus.ERROR
            }
        }
    }

    fun saveCoin(coin : Coin) = viewModelScope.launch {
        repository.insertOrUpdate(coin)
    }
}
