package com.hci.obtt.ui.tab.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.databinding.ItemRecommendationBinding
import com.hci.obtt.model.Recommendation

class RecommendationAdapter
    : ListAdapter<Recommendation, RecommendationAdapter.RecommendationViewHolder>(RECOMMENDATION_DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {

    }

    class RecommendationViewHolder(private val binding: ItemRecommendationBinding)
        : RecyclerView.ViewHolder(binding.root) {

    }

    companion object {

        val RECOMMENDATION_DIFF_UTIL = object : DiffUtil.ItemCallback<Recommendation>() {
            override fun areItemsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}