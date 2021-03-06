package com.polotechnologies.leaderboard.repository

import com.polotechnologies.leaderboard.dataModel.SubmitProject
import com.polotechnologies.leaderboard.network.SubmissionApiService
import javax.inject.Inject

class SubmissionRepository
@Inject constructor(private val submissionApi: SubmissionApiService) {

    suspend fun submitProject(project: SubmitProject) =
        submissionApi.submitProject(
            project.firstName,
            project.lastName,
            project.emailAddress,
            project.projectLink

        )
}