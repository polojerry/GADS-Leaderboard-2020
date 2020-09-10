package com.polotechnologies.leaderboard.di

import com.polotechnologies.leaderboard.network.LeadersBoardApi
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(ActivityComponent::class)
object LeadersModule {

    @Provides
    fun providesLeadersBoardApiService(): LeadersBoardApiService {
        return LeadersBoardApi.retrofitService
    }

    @Provides
    fun providesLeadersboardRepository(leadersBoardApi: LeadersBoardApiService) =
            LeadersBoardRepository(leadersBoardApi)

}