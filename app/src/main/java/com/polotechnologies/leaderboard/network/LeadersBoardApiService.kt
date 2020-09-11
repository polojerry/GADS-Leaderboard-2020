package com.polotechnologies.leaderboard.network

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.util.Constants.LEADERS_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(LEADERS_BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface LeadersBoardApiService {

    @GET("/api/hours")
    suspend fun learningLeaders() : List<LearningLeader>

    @GET(" /api/skilliq")
    suspend fun skillIqLeaders() : List<SkillIqLeader>

}

object LeadersBoardApi {
    val retrofitService : LeadersBoardApiService  by lazy {
        retrofit.create(LeadersBoardApiService::class.java)
    }
}




