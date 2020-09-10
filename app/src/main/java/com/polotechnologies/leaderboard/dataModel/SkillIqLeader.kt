package com.polotechnologies.leaderboard.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "table_skill_iq_leaders")
@JsonClass(generateAdapter = true)
data class SkillIqLeader(
        @PrimaryKey(autoGenerate = true)
        val learnerId: Int,

        val name: String,
        val score: Int,
        val country: String,
        val badgeUrl: String,
)