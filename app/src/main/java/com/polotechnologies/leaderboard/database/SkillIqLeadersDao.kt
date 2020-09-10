package com.polotechnologies.leaderboard.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader

@Dao
interface SkillIqLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg skillIqLeader: SkillIqLeader)

    @Query("SELECT * FROM table_skill_iq_leaders")
    fun getSkillIqLeaders() : LiveData<List<SkillIqLeader>>
}