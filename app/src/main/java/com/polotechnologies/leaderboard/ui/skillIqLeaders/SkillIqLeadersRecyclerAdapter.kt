package com.polotechnologies.leaderboard.ui.skillIqLeaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.leaderboard.dataModel.SkillIqLeader
import com.polotechnologies.leaderboard.databinding.ItemSkillIqLeaderBinding

class SkillIqLeadersRecyclerAdapter :
    ListAdapter<SkillIqLeader, SkillIqLeadersRecyclerAdapter.SkillIqLeadersViewHolder>(
        LearningLeadersDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIqLeadersViewHolder {
        return SkillIqLeadersViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SkillIqLeadersViewHolder, position: Int) {
        val skillIqLeader = getItem(position)
        holder.bind(skillIqLeader)
    }

    class SkillIqLeadersViewHolder(private val binding: ItemSkillIqLeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(skillIqLeader: SkillIqLeader) {
            binding.skillIqLeader = skillIqLeader
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): SkillIqLeadersViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val itemSkillIqLeaderBinding =
                    ItemSkillIqLeaderBinding.inflate(layoutInflater, parent, false)

                return SkillIqLeadersViewHolder(itemSkillIqLeaderBinding)
            }
        }

    }

    class LearningLeadersDiffUtil : DiffUtil.ItemCallback<SkillIqLeader>() {
        override fun areItemsTheSame(oldItem: SkillIqLeader, newItem: SkillIqLeader): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: SkillIqLeader, newItem: SkillIqLeader): Boolean {
            return oldItem == newItem
        }

    }
}