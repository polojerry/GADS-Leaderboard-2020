package com.polotechnologies.leaderboard.ui.learningLeaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.leaderboard.dataModel.LearningLeader
import com.polotechnologies.leaderboard.databinding.ItemLearningLeaderBinding

class LearningLeadersRecyclerAdapter :
    ListAdapter<LearningLeader, LearningLeadersRecyclerAdapter.LearningLeadersViewHolder>(
        LearningLeadersDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningLeadersViewHolder {
        return LearningLeadersViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearningLeadersViewHolder, position: Int) {
        val learningLeader = getItem(position)
        holder.bind(learningLeader)
    }

    class LearningLeadersViewHolder(private val binding: ItemLearningLeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(learningLeader: LearningLeader) {
            binding.learningLeader = learningLeader
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): LearningLeadersViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val itemLearningLeaderBinding =
                    ItemLearningLeaderBinding.inflate(layoutInflater, parent, false)

                return LearningLeadersViewHolder(itemLearningLeaderBinding)
            }
        }

    }

    class LearningLeadersDiffUtil : DiffUtil.ItemCallback<LearningLeader>() {
        override fun areItemsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
            return oldItem == newItem
        }

    }
}