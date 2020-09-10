package com.polotechnologies.leaderboard.repository

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LeadersBoardRepository
@Inject constructor(private val leadersBoardApi: LeadersBoardApiService) {

    @ExperimentalCoroutinesApi
    fun getLearningLeaders(): Flow<List<LearningLeader>> {
        return flow {

            val learnersList = leadersBoardApi.learningLeaders()

            emit(learnersList)

        }.flowOn(Dispatchers.Main)
    }


    @ExperimentalCoroutinesApi
    fun getSkillIqLeaders(): Flow<List<SkillIqLeader>> {
        return flow {

            val skillIqLeader = leadersBoardApi.skillIqLeaders()

            emit(skillIqLeader)

        }.flowOn(Dispatchers.Main)
    }


}