package com.polotechnologies.leaderboard.repository

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.network.LeadersBoardApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LeadersBoardRepository {

    /*val leadersBoardApi = LeadersBoardApi.retrofitService

    @ExperimentalCoroutinesApi
    fun getLearningLeaders() : Flow<List<LearningLeader>>{
        return flow {

            val learnersList = leadersBoardApi.learningLeaders()

            emit(learnersList)

        }.flowOn(Dispatchers.Main)
    }*/
}