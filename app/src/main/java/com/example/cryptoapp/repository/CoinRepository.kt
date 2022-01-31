package com.example.cryptoapp.repository

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto

class CoinRepository() {

    suspend fun getCoins(): List<CoinDto> {
        return CoinPaprikaApi.retrofitService.getCoins()
    }

    suspend fun getCoinById(coinId: String): CoinDetailDto {
        return CoinPaprikaApi.retrofitService.getCoinById(coinId)
    }
}