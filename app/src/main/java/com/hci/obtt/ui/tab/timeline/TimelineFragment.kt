package com.hci.obtt.ui.tab.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentTimelineBinding
import com.hci.obtt.databinding.ItemOttBinding
import com.hci.obtt.databinding.ItemTimelineBinding
import com.hci.obtt.model.DummyDataPool
import com.hci.obtt.model.Video
import com.hci.obtt.ui.base.BaseFragment

class TimelineFragment : BaseFragment<FragmentTimelineBinding>(R.layout.fragment_timeline) {

    private val adapter = TimelineAdapter(DummyDataPool.videos)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
    }


    private class TimelineAdapter(private val list: List<Video>) : RecyclerView.Adapter<TimelineViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
            val binding = ItemTimelineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TimelineViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

    }


    private class TimelineViewHolder(private val binding: ItemTimelineBinding) : RecyclerView.ViewHolder(binding.root) {

        class OttViewHolder(private val binding: ItemOttBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int) {
                binding.image.setImageResource(
                    when (position) {
                        1 -> R.drawable.netflix
                        2 -> R.drawable.disney
                        else -> R.drawable.watcha
                    }
                )
            }

        }

        fun bind(item: Video) {
            Glide.with(binding.imageThumbnail).load(item.thumbnail).into(binding.imageThumbnail)
            binding.textTitle.text = item.title
            binding.textDetail.text = item.genre

            binding.recycler.adapter = object : RecyclerView.Adapter<OttViewHolder>() {

                val size = (1..3).random()

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OttViewHolder {
                    val binding = ItemOttBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    return OttViewHolder(binding)
                }

                override fun onBindViewHolder(holder: OttViewHolder, position: Int) {
                    holder.bind(position)
                }

                override fun getItemCount() = size

            }
        }
    }


    companion object {

        fun newInstance() = TimelineFragment()

    }
}