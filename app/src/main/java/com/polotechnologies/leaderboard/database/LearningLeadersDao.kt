package com.polotechnologies.leaderboard.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotechnologies.leaderboard.dataModel.LearningLeader

@Dao
interface LearningLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg learningLeader : LearningLeader)

    @Query("SELECT * FROM table_learning_leaders")
    fun getLearningLeaders() : LiveData<List<LearningLeader>>
}