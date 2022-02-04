package com.example.cryptoapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.cryptoapp.data.database.entities.CoinDetailsDb

@Dao
interface CoinDetailDao {

    @Query("SELECT * FROM coindetailsdb")
    fun getAllCoinDetails(): LiveData<List<CoinDetailsDb>>

}