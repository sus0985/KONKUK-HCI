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
            R.drawable.user06,
            "3스파영원해",
            "스파이더맨 정주행 달린다",
            "#디즈니플러스 #마블 #스파이더맨 #톰홀랜드"
        ),
        Community(
            R.drawable.user07,
            "집돌이LV99",
            "스릴러 장르가 짱이다(주관 100%)",
            "#넷플릭스 #스릴러"
        ),
        Community(
            R.drawable.user08,
            "움파룸파",
            "요즘 볼만한 거 추천 좀 해주세요",
            "#추천 #넷플릭스 #왓챠"
        ),
        Community(
            R.drawable.user09,
            "다둥이아빠",
            "얘들이랑 짱구극장판 봤어요^^",
            "#가족영화 #애니메이션"
        ),
        Community(
            R.drawable.user10,
            "안녕내이름은",
            "코난! 탐정이죠!",
            "#코난 #존잼"
        ),
        Community(
            R.drawable.user11,
            "야구가세상을구한다",
            "퍼펙트게임 보고 감동받았어요ㅠㅠ",
            "#야구영화 #뭉클"
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
        binding.userImage.setImageResource(item.img)
        binding.userId.text = item.id
        binding.textDetail.text = item.detail
        binding.textTag.text = item.tag
    }

}