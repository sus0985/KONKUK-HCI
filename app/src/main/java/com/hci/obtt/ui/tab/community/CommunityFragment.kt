package com.hci.obtt.ui.tab.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentCommunityBinding
import com.hci.obtt.databinding.ItemCommunityBinding
import com.hci.obtt.model.Community
import com.hci.obtt.ui.base.BaseFragment

class CommunityFragment : BaseFragment<FragmentCommunityBinding>(R.layout.fragment_community) {

    private val communityList = listOf(
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        ),
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        ),
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        ),
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        ),
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        ),
        Community(
            "3스파영원해",
            "마블세계관 타임라인 정리 및 정주행 정리글",
            "#넷플릭스 #존잼"
        )
    )

    private val adapter = CommunityAdapter(communityList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
    }

    companion object {

        fun newInstance() = CommunityFragment()

    }
}

class CommunityAdapter(private val list: List<Community>) : RecyclerView.Adapter<CommunityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        val binding = ItemCommunityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class CommunityViewHolder(private val binding: ItemCommunityBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Community) {
        binding.userImage.setImageResource(R.drawable.user05)
        binding.userId.text = item.id
        binding.textDetail.text = item.detail
        binding.textTag.text = item.tag
    }

}