package com.polotechnologies.leaderboard.network

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.database.entities.DatabaseLearningLeader
import com.polotechnologies.leaderboard.database.entities.DatabaseSkillIqLeader
import com.squareup.moshi.JsonClass

/**
 * Contains List of Leaders.
 */
@JsonClass(generateAdapter = true)
data class NetworkLearningLeadersContainer(val learningLeaders: List<LearningLeader>)

@JsonClass(generateAdapter = true)
data class NetworkSkillIqLeadersContainer(val skillIqLeaders: List<SkillIqLeader>)

/**
 * Convert Network results to database objects
 */
fun List<LearningLeader>.asDatabaseModel(): Array<DatabaseLearningLeader> {
    return map {
        DatabaseLearningLeader(
            learnerId = 0,
            name = it.name,
            hours = it.hours,
            country = it.country,
            badgeUrl = it.badgeUrl
        )
    }.toTypedArray()
}

fun List<SkillIqLeader>.asDatabaseModel(): Array<DatabaseSkillIqLeader> {
    return map {
        DatabaseSkillIqLeader(
            learnerId = 0,
            name = it.name,
            score = it.score,
            country = it.country,
            badgeUrl = it.badgeUrl
        )
    }.toTypedArray()
}

