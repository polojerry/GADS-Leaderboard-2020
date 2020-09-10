package com.polotechnologies.leaderboard.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.util.Constants.DATABASE_LEADER_BOARD_NAME

@Database(entities = [LearningLeader::class, SkillIqLeader::class], version = 1, exportSchema = false)

abstract class LeaderboardDatabase : RoomDatabase() {

    abstract val learningLeadersDao: LearningLeadersDao
    abstract val skillIqLeadersDao: SkillIqLeadersDao

    companion object {
        @Volatile
        private var INSTANCE: LeaderboardDatabase? = null

        fun getDatabase(context: Context): LeaderboardDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            LeaderboardDatabase::class.java,
                            DATABASE_LEADER_BOARD_NAME
                    )
                            .fallbackToDestructiveMigration()
                            .build()

                    INSTANCE = instance
                }

                return instance

            }
        }

    }
}