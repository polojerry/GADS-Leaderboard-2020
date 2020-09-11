package com.polotechnologies.leaderboard.repository

import android.util.Log
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

    val learningLeaders: Flow<List<LearningLeader>> =
        learningLeadersDao.getLearningLeaders().map {
            it.asDomainModel()
        }


    val skillIqLeaders: Flow<List<SkillIqLeader>> =
        skillIqLeadersDao.getSkillIqLeaders().map {
            it.asDomainModel()
        }

    suspend fun getLearningLeaders() {

        flow {
            val skillIqLeader = leadersBoardApi.learningLeaders()
            emit(skillIqLeader)
        }.flowOn(Dispatchers.IO)
            .catch{
                Log.d(TAG, "getLearningLeaders: Error: ")
            }
            .collect { learningLeadersList ->
                learningLeadersDao.insertAll(*learningLeadersList.asDatabaseModel())
            }


    }


    suspend fun getSkillIqLeaders() {
        flow {
            val skillIqLeader = leadersBoardApi.skillIqLeaders()
            emit(skillIqLeader)
        }.flowOn(Dispatchers.IO)
            .catch{
                Log.d(TAG, "getSkillIqLeaders: Error: ")
            }
            .collect { skillIqLeaders ->
                skillIqLeadersDao.insertAll(*skillIqLeaders.asDatabaseModel())
            }
    }


    companion object {
        const val TAG = "LeaderBoardRepository"
    }


}
