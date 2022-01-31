package com.example.cryptoapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.database.entities.CoinDb
import com.example.cryptoapp.model.Coin

@Dao
interface CoinDao {

    @Query("SELECT * FROM coindb")
    fun getSavedCoins(): LiveData<List<CoinDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(coin: CoinDb) : Long
}