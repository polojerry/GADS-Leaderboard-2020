package com.polotechnologies.leaderboard.ui.learningLeaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.LearningLeadersFragmentBinding

class LearningLeadersFragment : Fragment() {

    private lateinit var viewModel: LearningLeadersViewModel

    private lateinit var binding: LearningLeadersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.learning_leaders_fragment, container, false)

        return binding.root
    }

}