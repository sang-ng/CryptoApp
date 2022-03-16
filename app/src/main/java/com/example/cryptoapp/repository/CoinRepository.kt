package com.example.cryptoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.cryptoapp.data.database.CoinsDatabaseImp
import com.example.cryptoapp.data.database.entities.toCoin
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.data.domain.model.Coin
import com.example.cryptoapp.data.domain.model.toCoinDb
import com.example.cryptoapp.data.remote.CoinApiService
import retrofit2.Response

class CoinRepository(
    private val db: CoinsDatabaseImp,
    private val retrofitService: CoinApiService
) {

    suspend fun getCoins() =
        retrofitService.getCoins()

    suspend fun getCoinById(coinId: String) =
        retrofitService.getCoinById(coinId)


    suspend fun insertOrUpdate(coin: Coin) {
        db.coinDao.insertOrUpdate(coin.toCoinDb())
    }

    fun getSavedCoins(): LiveData<List<Coin>> = Transformations.map(db.coinDao.getSavedCoins()) {
        it.toCoin()
    }
}