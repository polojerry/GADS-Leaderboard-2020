package com.polotechnologies.leaderboard.repository

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.database.LearningLeadersDao
import com.polotechnologies.leaderboard.database.SkillIqLeadersDao
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalCoroutinesApi
class LeadersBoardRepository
@Inject constructor(
    private val leadersBoardApi: LeadersBoardApiService,
    private val learningLeadersDao: LearningLeadersDao,
    private val skillIqLeadersDao: SkillIqLeadersDao
) {

    /*@ExperimentalCoroutinesApi
    fun getLearningLeaders(): Flow<List<LearningLeader>> {
        return flow {

            val learnersList = leadersBoardApi.learningLeaders()

            emit(learnersList)

        }.flowOn(Dispatchers.Main)
    }
*/


    /* @ExperimentalCoroutinesApi
     fun getSkillIqLeaders(): Flow<List<SkillIqLeader>> {
         return flow {

             val skillIqLeader = leadersBoardApi.skillIqLeaders()

             emit(skillIqLeader)

         }.flowOn(Dispatchers.Main)
     }
     */

    suspend fun getLearningLeaders() {
        leadersBoardApi.learningLeaders().flowOn(Dispatchers.Main).collect { learningLeadersList ->
            learningLeadersDao.insertAll(*learningLeadersList.toTypedArray())
        }
    }


    suspend fun getSkillIqLeaders() {
        leadersBoardApi.skillIqLeaders().flowOn(Dispatchers.Main).collect { skillIqLeaders ->
            skillIqLeadersDao.insertAll(*skillIqLeaders.toTypedArray())
        }
    }

    val learningLeaders: Flow<List<LearningLeader>> =
        learningLeadersDao.getLearningLeaders()

    val skillIqLeaders: Flow<List<SkillIqLeader>> =
        skillIqLeadersDao.getSkillIqLeaders()

}