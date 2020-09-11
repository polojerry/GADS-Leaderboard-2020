package com.polotechnologies.leaderboard.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.squareup.moshi.JsonClass

@Entity(tableName = "table_skill_iq_leaders")
@JsonClass(generateAdapter = true)
data class DatabaseSkillIqLeader(
    @PrimaryKey(autoGenerate = true)
    val learnerId: Int,

    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String,
)

fun List<DatabaseSkillIqLeader>.asDomainModel(): List<SkillIqLeader> {
    return map {
        SkillIqLeader(
            name = it.name,
            score = it.score,
            country = it.country,
            badgeUrl = it.badgeUrl
        )
    }
}