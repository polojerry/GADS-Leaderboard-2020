package com.polotechnologies.leaderboard.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "table_learning_leaders")
@JsonClass(generateAdapter = true)
data class LearningLeader(
        @PrimaryKey(autoGenerate = true)
        val learnerId: Int,

        val name: String,
        val hours: Int,
        val country: String,
        val badgeUrl: String,
)