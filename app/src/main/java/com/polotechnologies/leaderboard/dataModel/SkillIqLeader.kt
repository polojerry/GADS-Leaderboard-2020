package com.polotechnologies.leaderboard.dataModel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SkillIqLeader(
        val name: String,
        val score: Int,
        val country: String,
        val badgeUrl: String,
)