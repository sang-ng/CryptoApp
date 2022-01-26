package com.example.cryptoapp.model

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
