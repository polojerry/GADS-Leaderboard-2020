package com.polotechnologies.leaderboard.di

import com.polotechnologies.leaderboard.network.SubmissionApi
import com.polotechnologies.leaderboard.network.SubmissionApiService
import com.polotechnologies.leaderboard.repository.SubmissionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SubmissionModule {
    @Provides
    fun providesSubmissionApiService(): SubmissionApiService {
        return SubmissionApi.retrofitService
    }

    @Provides
    fun providesSubmissionRepository(submissionApi: SubmissionApiService) =
        SubmissionRepository(submissionApi)

}