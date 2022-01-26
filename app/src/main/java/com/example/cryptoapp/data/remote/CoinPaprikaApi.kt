package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CoinApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}

object CoinPaprikaApi {
    val retrofitService: CoinApiService by lazy { retrofit.create(CoinApiService::class.java) }
}