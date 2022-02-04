package com.example.cryptoapp.data.database

import androidx.room.TypeConverter
import com.example.cryptoapp.data.remote.dto.Whitepaper

class Converters {

    @TypeConverter
    fun fromWhitepaper(whitepaper: Whitepaper): String {
        return whitepaper.link
    }

    @TypeConverter
    fun toWhitepaper(link: String): Whitepaper {
        return Whitepaper(link, link)
    }
}