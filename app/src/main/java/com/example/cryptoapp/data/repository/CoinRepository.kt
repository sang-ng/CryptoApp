package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto

class CoinRepository(private val api: CoinPaprikaApi) {

    suspend fun getcoins(): List<CoinDto> {
        return api.getCoins()
    }

    suspend fun getcoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}