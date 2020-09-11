package com.polotechnologies.leaderboard.di

import com.polotechnologies.leaderboard.database.LeaderboardDatabase
import com.polotechnologies.leaderboard.database.LearningLeadersDao
import com.polotechnologies.leaderboard.database.SkillIqLeadersDao
import com.polotechnologies.leaderboard.network.LeadersBoardApi
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(ActivityComponent::class)
object LeadersModule {

    @Provides
    fun providesLeadersBoardApiService(): LeadersBoardApiService {
        return LeadersBoardApi.retrofitService
    }

    @ExperimentalCoroutinesApi
    @Provides
    fun providesLeadersboardRepository(
        leadersBoardApi: LeadersBoardApiService,
        learningLeadersDao: LearningLeadersDao,
        skillIqLeadersDao: SkillIqLeadersDao
    ) =
        LeadersBoardRepository(leadersBoardApi, learningLeadersDao, skillIqLeadersDao)

    @Provides
    fun providesLearningLeadersDao(database: LeaderboardDatabase) =
        database.learningLeadersDao


    @Provides
    fun providesSkillIqLeadersDao(database : LeaderboardDatabase) =
        database.skillIqLeadersDao


}