package com.polotechnologies.leaderboard.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.database.entities.DatabaseLearningLeader
import com.polotechnologies.leaderboard.database.entities.DatabaseSkillIqLeader
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg learningLeader : DatabaseLearningLeader)

    @Query("SELECT * FROM table_learning_leaders")
    fun getLearningLeaders() : Flow<List<DatabaseLearningLeader>>
}