package com.example.cryptoapp.data.remote.dto

import com.example.cryptoapp.data.database.entities.CoinDb
import com.example.cryptoapp.data.domain.model.Coin
import com.google.gson.annotations.SerializedName

//DTO(= Data transfer object, object, which we get from API)
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDto.toCoinDb(): CoinDb {
    return CoinDb(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}