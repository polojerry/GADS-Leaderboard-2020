package com.polotechnologies.leaderboard.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg learningLeader : LearningLeader)

    @Query("SELECT * FROM table_learning_leaders")
    fun getLearningLeaders() : Flow<List<LearningLeader>>
}