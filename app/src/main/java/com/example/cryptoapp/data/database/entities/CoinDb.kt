package com.example.cryptoapp.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cryptoapp.data.remote.dto.CoinDto
import com.example.cryptoapp.model.Coin
import com.google.gson.annotations.SerializedName

@Entity(indices = [Index(value = ["id", "name"],
    unique = true)])
data class CoinDb constructor(
    @PrimaryKey(autoGenerate = true)
    val _id: Long? ,
    val id:String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

fun List<CoinDb>.toCoin(): List<Coin> {
    return map {
        Coin(
            id = it.id.toString(),
            isActive = it.isActive,
            name = it.name,
            rank = it.rank,
            symbol = it.symbol
        )
    }
}

fun CoinDb.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}