package com.polotechnologies.leaderboard.repository

import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.database.LearningLeadersDao
import com.polotechnologies.leaderboard.database.SkillIqLeadersDao
import com.polotechnologies.leaderboard.database.entities.DatabaseLearningLeader
import com.polotechnologies.leaderboard.database.entities.asDomainModel
import com.polotechnologies.leaderboard.network.LeadersBoardApiService
import com.polotechnologies.leaderboard.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
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

        flow {
            val skillIqLeader = leadersBoardApi.learningLeaders()
            emit(skillIqLeader)
        }.flowOn(Dispatchers.IO)
            .collect { learningLeadersList ->
                learningLeadersDao.insertAll(*learningLeadersList.asDatabaseModel())
            }

        /*leadersBoardApi.learningLeaders().flowOn(Dispatchers.Main).collect { learningLeadersList ->
            learningLeadersDao.insertAll(*learningLeadersList.toTypedArray())
        }*/
    }


    suspend fun getSkillIqLeaders() {
        flow {
            val skillIqLeader = leadersBoardApi.skillIqLeaders()
            emit(skillIqLeader)
        }.flowOn(Dispatchers.IO)
            .collect { skillIqLeaders ->
                skillIqLeadersDao.insertAll(*skillIqLeaders.asDatabaseModel())
            }
        /*leadersBoardApi.skillIqLeaders().flowOn(Dispatchers.Main).collect { skillIqLeaders ->
            skillIqLeadersDao.insertAll(*skillIqLeaders.toTypedArray())
        }*/
    }

    val learningLeaders: Flow<List<LearningLeader>> =
        learningLeadersDao.getLearningLeaders().map {
            it.asDomainModel()
        }


    val skillIqLeaders: Flow<List<SkillIqLeader>> =
        skillIqLeadersDao.getSkillIqLeaders().map {
            it.asDomainModel()
        }

}
