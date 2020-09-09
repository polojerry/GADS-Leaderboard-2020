package com.polotechnologies.leaderboard.ui.skillIqLeaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.SkillIqLeadersFragmentBinding

class SkillIqLeadersFragment : Fragment() {

    private lateinit var viewModel: SkillIqLeadersViewModel

    private lateinit var binding: SkillIqLeadersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.skill_iq_leaders_fragment, container, false)

        return binding.root
    }


}