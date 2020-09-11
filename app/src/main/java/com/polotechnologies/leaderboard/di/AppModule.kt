package com.polotechnologies.leaderboard.di

import android.content.Context
import com.polotechnologies.leaderboard.database.LeaderboardDatabase.Companion.getDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLeaderBoardDatabase(@ApplicationContext context: Context) = getDatabase(context)

}
