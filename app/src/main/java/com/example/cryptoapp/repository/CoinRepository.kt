package com.example.cryptoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.cryptoapp.data.database.CoinsDatabaseImp
import com.example.cryptoapp.data.database.entities.toCoin
import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.data.domain.model.Coin
import com.example.cryptoapp.data.domain.model.toCoinDb

class CoinRepository(val db: CoinsDatabaseImp) {

    suspend fun getCoins(): List<CoinDto> {
        return CoinPaprikaApi.retrofitService.getCoins()
    }

    suspend fun getCoinById(coinId: String): CoinDetailDto {
        return CoinPaprikaApi.retrofitService.getCoinById(coinId)
    }

    suspend fun insertOrUpdate(coin: Coin) {
        db.coinDao.insertOrUpdate(coin.toCoinDb())
    }

    fun getSavedCoins(): LiveData<List<Coin>> = Transformations.map(db.coinDao.getSavedCoins()) {
        it.toCoin()
    }
}