package com.polotechnologies.leaderboard.ui.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.dataModel.SubmitProject
import com.polotechnologies.leaderboard.databinding.DialogSubmissionErrorBinding
import com.polotechnologies.leaderboard.databinding.DialogSubmissionSuccessfulBinding
import com.polotechnologies.leaderboard.databinding.DialogSubmitProjectBinding
import com.polotechnologies.leaderboard.databinding.SubmissionFragmentBinding
import com.polotechnologies.leaderboard.network.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubmissionFragment : Fragment() {

    private val viewModel: SubmissionViewModel by viewModels()

    private lateinit var binding: SubmissionFragmentBinding
    private lateinit var submitDialog : AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.submission_fragment, container, false)

        setClickListeners()
        return binding.root
    }

    private fun setClickListeners() {
        binding.layoutToolbarSubmission.toolbarSubmission.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonSubmit.setOnClickListener {
            if (validateInputs()) {
                displaySubmissionDialog()
            }
        }
    }


    private fun submitAndObserve() {
        val project = SubmitProject(
            viewModel.firstName,
            viewModel.lastName,
            viewModel.emailAddress,
            viewModel.githubLink
        )

        viewModel.submitProject(project).observe(viewLifecycleOwner, { response ->
            when (response) {
                is NetworkResponse.Loading -> {

                }

                is NetworkResponse.Success -> {
                    showSuccessDialog()
                    clearProjectDetails()

                }

                is NetworkResponse.Failed -> {
                    showFailureDialog()

                }
            }

        })

    }

    private fun clearProjectDetails() {
        binding.textInputFirstName.text?.clear()
        binding.textInputLastName.text?.clear()
        binding.textInputEmailAddress.text?.clear()
        binding.textInputProjectOnGithub.text?.clear()
    }

    private fun displaySubmissionDialog() {
        submitDialog= requireActivity().let {
            val builder = AlertDialog.Builder(it)
            val layoutInflater = requireActivity().layoutInflater

            val submissionDialog = DialogSubmitProjectBinding.inflate(layoutInflater)
            submissionDialog.textLabelSubmitQuestionMark.text = "?"
            submissionDialog.buttonSubmitProject.setOnClickListener {
                submitAndObserve()
                submitDialog.dismiss()
            }
            builder.setView(submissionDialog.root)
            builder.create()
        }
        submitDialog.show()
    }

    private fun showSuccessDialog() {

        val alertDialog: AlertDialog = requireActivity().let {
            val builder = AlertDialog.Builder(it)
            val layoutInflater = requireActivity().layoutInflater

            val failureDialog = DialogSubmissionSuccessfulBinding.inflate(layoutInflater)
            builder.setView(failureDialog.root)
            builder.create()
        }
        alertDialog.show()


    }

    private fun showFailureDialog() {
        val alertDialog: AlertDialog = requireActivity().let {
            val builder = AlertDialog.Builder(it)
            val layoutInflater = requireActivity().layoutInflater

            val failureDialog = DialogSubmissionErrorBinding.inflate(layoutInflater)
            builder.setView(failureDialog.root)
            builder.create()
        }
        alertDialog.show()
    }

    private fun validateInputs(): Boolean {
        var isValid = false

        viewModel.firstName = binding.textInputFirstName.text.toString()
        viewModel.lastName = binding.textInputLastName.text.toString()
        viewModel.emailAddress = binding.textInputEmailAddress.text.toString()
        viewModel.githubLink = binding.textInputProjectOnGithub.text.toString()

        if (viewModel.firstName == "") {
            binding.textInputFirstName.error = "Required"
            isValid = false
        }
        if (viewModel.lastName == "") {
            binding.textInputLastName.error = "Required"
            isValid = false
        }
        if (viewModel.emailAddress == "") {
            binding.textInputEmailAddress.error = "Required"
            isValid = false
        }
        if (viewModel.githubLink == "") {
            binding.textInputProjectOnGithub.error = "Required"
            isValid = false
        }

        if (viewModel.firstName != "" && viewModel.lastName != "" && viewModel.emailAddress != "" && viewModel.githubLink != "") {
            isValid = true
        }

        return isValid

    }

}