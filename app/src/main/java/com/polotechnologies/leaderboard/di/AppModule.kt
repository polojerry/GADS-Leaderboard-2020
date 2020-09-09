package com.polotechnologies.leaderboard.di

import com.polotechnologies.leaderboard.network.LeadersBoardApi
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
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
    fun providesLeadersboardRepository(leadersBoardApi: LeadersBoardApiService) =
        LeadersBoardRepository(leadersBoardApi)

}