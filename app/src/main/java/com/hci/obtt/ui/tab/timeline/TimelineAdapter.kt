package com.hci.obtt.ui.tab.timeline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.databinding.ItemTimelineBinding
import com.hci.obtt.model.Video

class TimelineAdapter(
    private val list: List<Video>
) : RecyclerView.Adapter<TimelineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val binding =
            ItemTimelineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimelineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {

    }

    override fun getItemCount() = list.size

}

class TimelineViewHolder(private val binding: ItemTimelineBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
