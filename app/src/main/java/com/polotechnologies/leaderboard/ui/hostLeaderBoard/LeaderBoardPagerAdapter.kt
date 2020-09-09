package com.polotechnologies.leaderboard.ui.hostLeaderBoard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.polotechnologies.leaderboard.ui.learningLeaders.LearningLeadersFragment
import com.polotechnologies.leaderboard.ui.skillIqLeaders.SkillIqLeadersFragment

class LeaderBoardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int  = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LearningLeadersFragment()
            1-> SkillIqLeadersFragment()
            else -> LearningLeadersFragment()
        }
    }
}