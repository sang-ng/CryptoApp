package com.example.cryptoapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.model.Coin
import com.google.gson.annotations.SerializedName

@Entity
data class CoinDb constructor(
    @PrimaryKey(autoGenerate = true)
    val _id: Long = 0,
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