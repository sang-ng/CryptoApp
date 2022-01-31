package com.example.cryptoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CoinDetailDao {

    @Query("SELECT * FROM coindetailsdb")
    fun getAllCoinDetails(): LiveData<List<CoinDetailsDb>>

}