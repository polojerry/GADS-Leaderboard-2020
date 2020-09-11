package com.polotechnologies.leaderboard.ui.learningLeaders

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class LearningLeadersViewModel @ViewModelInject constructor(private val leadersBoardRepository: LeadersBoardRepository) :
    ViewModel() {

    private val _learningLeaders = MutableLiveData<List<LearningLeader>>()
    val learningLeaders: LiveData<List<LearningLeader>>
        get() = _learningLeaders

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        refreshLearningLeaders()
        getLearningLeaders()
    }

    private fun refreshLearningLeaders() {
        viewModelScope.launch {
            leadersBoardRepository.getLearningLeaders()
        }
    }

    private fun getLearningLeaders() = viewModelScope.launch {
        leadersBoardRepository.learningLeaders.collect { learningLeadersList ->
            _learningLeaders.value = learningLeadersList
        }
    }
}