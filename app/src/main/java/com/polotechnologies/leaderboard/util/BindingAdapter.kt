package com.polotechnologies.leaderboard.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.polotechnologies.leaderboard.R

@BindingAdapter("imageUrl")
fun bind(imageView: AppCompatImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}

@BindingAdapter("learningHours")
fun bindHours(textView: AppCompatTextView, hours: Int) {
    val textLearningHours =
        textView.context.resources.getString(R.string.format_learning_hours, hours)
    textView.text = textLearningHours

}

@BindingAdapter("skillIq")
fun bindIq(textView: AppCompatTextView, score: Int) {
    val textSkillIq =
        textView.context.resources.getString(R.string.format_skill_iq_score, score)
    textView.text = textSkillIq
}