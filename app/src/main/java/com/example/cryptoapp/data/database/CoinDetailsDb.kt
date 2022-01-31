package com.example.cryptoapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.data.remote.dto.*

@Entity
data class CoinDetailsDb constructor(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
//    val links: Links,
//    val links_extended: List<LinksExtended>,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
//    val tags: List<Tag>,
//    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)
