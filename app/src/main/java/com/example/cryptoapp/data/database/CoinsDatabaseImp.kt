package com.example.cryptoapp.data.database

import android.content.Context
import androidx.room.*

@Database(
    entities = [CoinDb::class, CoinDetailsDb::class],
    version = 1, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class CoinsDatabaseImp : RoomDatabase() {
    abstract val coinDao: CoinDao
    abstract val coinDetailDao: CoinDetailDao

    companion object {
        private lateinit var INSTANCE: CoinsDatabaseImp

        fun getDatabase(context: Context): CoinsDatabaseImp {
            synchronized(CoinsDatabaseImp::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CoinsDatabaseImp::class.java,
                        "coins_db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}
