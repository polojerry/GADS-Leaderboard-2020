package com.polotechnologies.leaderboard.ui.skillIqLeaders

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.repository.LeadersBoardRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class SkillIqLeadersViewModel @ViewModelInject constructor(private val leadersBoardRepository: LeadersBoardRepository) :
    ViewModel() {


    private val _skillIqLeaders = MutableLiveData<List<SkillIqLeader>>()
    val skillIqLeaders: LiveData<List<SkillIqLeader>>
        get() = _skillIqLeaders

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        refreshSkillIqLeaders()
        getSkillIqLeaders()
    }

    private fun refreshSkillIqLeaders() {
        viewModelScope.launch {
            leadersBoardRepository.getSkillIqLeaders()
        }
    }

    private fun getSkillIqLeaders() = viewModelScope.launch {
        leadersBoardRepository.skillIqLeaders.collect { skillIqLeadersList ->
            _skillIqLeaders.value = skillIqLeadersList
        }
    }

}