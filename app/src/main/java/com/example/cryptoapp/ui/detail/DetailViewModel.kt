package com.example.cryptoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.remote.dto.toCoinDetail
import com.example.cryptoapp.repository.CoinRepository
import com.example.cryptoapp.data.domain.model.Coin
import com.example.cryptoapp.data.domain.model.CoinDetail
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: CoinRepository
) : ViewModel() {

    enum class CoinApiStatus { LOADING, ERROR, SUCCESS }
    enum class SaveCoinStatus {ERROR, SUCCESS}

    val apiStatus: LiveData<CoinApiStatus>
        get() = _apiStatus

    val saveStatus: LiveData<SaveCoinStatus>
        get() = _saveStatus

    val coin: LiveData<CoinDetail>
        get() = _coin

    private val _apiStatus = MutableLiveData<CoinApiStatus>()
    private val _coin = MutableLiveData<CoinDetail>()
    private val _saveStatus = MutableLiveData<SaveCoinStatus>()


    fun getCoinById(coindId: String) {
        viewModelScope.launch {
            _apiStatus.value = CoinApiStatus.LOADING

            try {
                _coin.value = repository.getCoinById(coindId).toCoinDetail()
                _apiStatus.value = CoinApiStatus.SUCCESS
            } catch (e: Exception) {
                _apiStatus.value = CoinApiStatus.ERROR
            }
        }
    }

    fun saveCoin(coin : Coin) {
        viewModelScope.launch {
            try{
                repository.insertOrUpdate(coin)
                _saveStatus.value = SaveCoinStatus.SUCCESS
            }catch (e:Exception){
                _saveStatus.value = SaveCoinStatus.ERROR
            }
        }
    }
}
