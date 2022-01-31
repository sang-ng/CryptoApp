package com.example.cryptoapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.cryptoapp.data.database.entities.CoinDb

@Dao
interface CoinDao {

    @Query("SELECT * FROM coindb")
    fun getAllCoins(): LiveData<List<CoinDb>>
}