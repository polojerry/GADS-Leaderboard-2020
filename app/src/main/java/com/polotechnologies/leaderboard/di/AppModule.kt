package com.polotechnologies.leaderboard.di

import com.polotechnologies.leaderboard.network.LeadersBoardApi
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import com.polotechnologies.leaderboard.network.SubmissionApi
import com.polotechnologies.leaderboard.network.SubmissionApiService
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import com.polotechnologies.leaderboard.repository.SubmissionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    fun providesLeadersBoardApiService(): LeadersBoardApiService {
        return LeadersBoardApi.retrofitService
    }

    @Provides
    fun providesSubmissionApiService(): SubmissionApiService {
        return SubmissionApi.retrofitService
    }

    @Provides
    fun providesLeadersboardRepository(leadersBoardApi: LeadersBoardApiService) =
        LeadersBoardRepository(leadersBoardApi)

    @Provides
    fun providesSubmissionRepository(submissionApi: SubmissionApiService) =
        SubmissionRepository(submissionApi)

}