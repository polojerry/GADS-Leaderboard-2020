package com.polotechnologies.leaderboard.ui.learningLeaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LearningLeadersViewModel : ViewModel() {
    private val leadersBoardRepository = LeadersBoardRepository()

    private val _learningLeadersLeaders = MutableLiveData<List<LearningLeader>>()
    val learningLeadersLeaders: LiveData<List<LearningLeader>>
        get() = _learningLeadersLeaders

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getLearningLeaders()
    }

    private fun getLearningLeaders() {
        viewModelScope.launch {
            leadersBoardRepository.getLearningLeaders()
                .onStart {

                }.catch {

                }.collect {learningLeadersLeadersList->
                    _learningLeadersLeaders.value = learningLeadersLeadersList
                }
        }
    }
    
}