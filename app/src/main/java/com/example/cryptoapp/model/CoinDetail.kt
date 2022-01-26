package com.example.cryptoapp.model

import com.example.cryptoapp.data.remote.dto.TeamMember

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val type: String,
    val started_at: String,
    val proof_type: String,
    val development_status: String
)
