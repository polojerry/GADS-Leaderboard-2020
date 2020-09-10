package com.polotechnologies.leaderboard.ui.hostLeaderBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewBindingAdapter.setClickListener
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.HostLeaderBoardFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostLeaderBoardFragment : Fragment() {

    private lateinit var viewModel: HostLeaderBoardViewModel
    private lateinit var binding : HostLeaderBoardFragmentBinding
    private lateinit var leaderBoardPagerAdapter: LeaderBoardPagerAdapter

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout : TabLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.host_leader_board_fragment, container, false)

        setClickListener()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leaderBoardPagerAdapter = LeaderBoardPagerAdapter(this)
        viewPager = binding.viewPagerLeaderBoard
        tabLayout = binding.tabLayoutLeaderBoard


        viewPager.adapter = leaderBoardPagerAdapter
        TabLayoutMediator(tabLayout, viewPager){tab, position->
            when (position) {
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()
    }

    private fun setClickListener(){
        binding.layoutToolbarLeaderBoard.buttonSubmitLeaderboard.setOnClickListener {
            findNavController().navigate(R.id.action_hostLeaderBoardFragment_to_submissionFragment)
        }

    }

}