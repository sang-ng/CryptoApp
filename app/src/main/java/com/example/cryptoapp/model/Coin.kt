package com.example.cryptoapp.model

import com.example.cryptoapp.data.database.entities.CoinDb
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//object we want to use for presentation
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
) : Serializable

fun Coin.toCoinDb(): CoinDb {
    return CoinDb(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        isActive = isActive
    )
}
