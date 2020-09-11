package com.polotechnologies.leaderboard.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.squareup.moshi.JsonClass


@Entity(tableName = "table_learning_leaders")
@JsonClass(generateAdapter = true)
data class DatabaseLearningLeader(
    @PrimaryKey(autoGenerate = true)
    val learnerId: Int,

    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String,
)

fun List<DatabaseLearningLeader>.asDomainModel(): List<LearningLeader> {
    return map {
        LearningLeader(
            name = it.name,
            hours = it.hours,
            country = it.country,
            badgeUrl = it.badgeUrl)
    }
}