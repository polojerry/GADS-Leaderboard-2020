package com.polotechnologies.leaderboard.ui.submission

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.dataModel.SubmitProject
import com.polotechnologies.leaderboard.databinding.SubmissionFragmentBinding
import com.polotechnologies.leaderboard.network.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubmissionFragment : Fragment() {

    private val viewModel: SubmissionViewModel by viewModels()

    private lateinit var binding: SubmissionFragmentBinding

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
                submitAndObserve()
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
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()

                }

                is NetworkResponse.Success -> {
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()

                }

                is NetworkResponse.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed: ${response.exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Submission", "Error: ${response.exception.message}")

                }
            }

        })

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