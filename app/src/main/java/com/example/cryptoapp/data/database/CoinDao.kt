package com.example.cryptoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CoinDao {

    @Query("SELECT * FROM coindb")
    fun getAllCoins(): LiveData<List<CoinDb>>
}