package com.hci.obtt.ui.tab.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hci.obtt.databinding.ItemRecommendationBinding
import com.hci.obtt.model.Video

class RecommendationAdapter(private val onClick: (Int)->Unit)
    : ListAdapter<Video, RecommendationAdapter.RecommendationViewHolder>(RECOMMENDATION_DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    class RecommendationViewHolder(private val binding: ItemRecommendationBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Video, onClick: (Int)->Unit) {
            with(binding) {
                root.setOnClickListener { onClick(item.id) }
                imageThumbnail.clipToOutline = true
                Glide.with(imageThumbnail).load(item.thumbnail).into(binding.imageThumbnail)
                textTitle.text = item.title
            }
        }
    }

    companion object {

        val RECOMMENDATION_DIFF_UTIL = object : DiffUtil.ItemCallback<Video>() {
            override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}
