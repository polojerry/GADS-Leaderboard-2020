package com.polotechnologies.leaderboard.ui.submission

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.polotechnologies.leaderboard.dataModel.SubmitProject
import com.polotechnologies.leaderboard.network.NetworkResponse
import com.polotechnologies.leaderboard.repository.SubmissionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class SubmissionViewModel @ViewModelInject constructor(private val submissionRepository: SubmissionRepository) :
    ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var firstName: String = ""
    var lastName: String = ""
    var emailAddress: String = ""
    var githubLink: String = ""


    fun submitProject(project: SubmitProject) =
        liveData(viewModelScope.coroutineContext) {
            emit(NetworkResponse.loading())

            try {
                val response = submissionRepository.submitProject(project)
                emit(NetworkResponse.success(response))
            } catch (exception: Exception) {
                emit(NetworkResponse.failed<Exception>(exception))
            }
        }

}