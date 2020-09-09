package com.polotechnologies.leaderboard.ui.skillIqLeaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.SkillIqLeadersFragmentBinding
import com.polotechnologies.leaderboard.util.bind
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class SkillIqLeadersFragment : Fragment() {

    private val viewModel: SkillIqLeadersViewModel by viewModels()

    private lateinit var binding: SkillIqLeadersFragmentBinding
    private lateinit var skillIqLeadersRecyclerAdapter: SkillIqLeadersRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.skill_iq_leaders_fragment, container, false)

        skillIqLeadersRecyclerAdapter = SkillIqLeadersRecyclerAdapter()
        binding.recyclerViewSkillIqLeaders.adapter = skillIqLeadersRecyclerAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.skillIqLeaders.observe(viewLifecycleOwner, { skillIqLeaders ->
            skillIqLeadersRecyclerAdapter.submitList(skillIqLeaders)
        })
    }


}