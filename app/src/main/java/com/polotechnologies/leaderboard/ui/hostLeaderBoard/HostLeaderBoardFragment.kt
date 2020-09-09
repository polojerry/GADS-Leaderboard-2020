package com.polotechnologies.leaderboard.ui.hostLeaderBoard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.polotechnologies.leaderboard.R
import com.polotechnologies.leaderboard.databinding.HostLeaderBoardFragmentBinding

class HostLeaderBoardFragment : Fragment() {

    private lateinit var viewModel: HostLeaderBoardViewModel
    private lateinit var binding : HostLeaderBoardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.host_leader_board_fragment, container, false)
        return binding.root
    }

}