package com.polotechnologies.leaderboard.dataModel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LearningLeader(
        val name: String,
        val hours: Int,
        val country: String,
        val badgeUrl: String,
)