package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto


//defines the functions what we have, we use interface here for easy testcases
interface CoinRepository {

    suspend fun getcoins(): List<CoinDto>

    suspend fun getcoinById(coinId: String): CoinDetailDto
}