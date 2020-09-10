package com.polotechnologies.leaderboard.ui.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.SubmissionFragmentBinding

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
    }

}