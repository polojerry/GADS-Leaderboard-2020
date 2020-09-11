package com.polotechnologies.leaderboard.ui.learningLeaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.LearningLeadersFragmentBinding
import com.polotechnologies.leaderboard.ui.skillIqLeaders.SkillIqLeadersRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LearningLeadersFragment : Fragment() {

    private val viewModel: LearningLeadersViewModel by viewModels()

    private lateinit var binding: LearningLeadersFragmentBinding
    private lateinit var learningLeadersRecyclerAdapter: LearningLeadersRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.learning_leaders_fragment, container, false)

        learningLeadersRecyclerAdapter = LearningLeadersRecyclerAdapter()
        binding.recyclerViewLearningLeaders.adapter = learningLeadersRecyclerAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.learningLeaders.observe(viewLifecycleOwner, { learningLeaders ->
            learningLeadersRecyclerAdapter.submitList(learningLeaders)
        })
    }


}