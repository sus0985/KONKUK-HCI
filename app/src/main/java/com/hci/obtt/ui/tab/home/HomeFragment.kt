package com.hci.obtt.ui.tab.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentHomeBinding
import com.hci.obtt.databinding.ItemContentsBinding
import com.hci.obtt.databinding.ItemRankingBinding
import com.hci.obtt.model.Contents
import com.hci.obtt.model.Ranking
import com.hci.obtt.model.Recommendation
import com.hci.obtt.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val rankingAdapter = object : RecyclerView.Adapter<RankingViewHolder>() {

        private val item = listOf(
            Ranking(1, 1, "파친코", "Apple+", "1시간/6화", "드라마", 4.9f),
            Ranking(2, 2, "스파이 패밀리", "Netflix", "1시간/12화", "애니메이션", 4.8f),
            Ranking(3, 3, "나이트메어 엘리", "Disney+", "2시간 17분", "영화", 4.5f)
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
            val binding = ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RankingViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
            holder.bind(item[position])
        }

        override fun getItemCount(): Int = item.size
    }

    private val contentsAdapter = object : RecyclerView.Adapter<ContentsViewHolder>() {

        private val item = listOf(
            Contents(0, "오늘 뭘 볼까?\n랜덤 추천!"),
            Contents(1, "연령별 추천"),
            Contents(2, "요금제 공유\n구인 관리"),
            Contents(3, "고객 문의")
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentsViewHolder {
            val binding = ItemContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ContentsViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ContentsViewHolder, position: Int) {
            holder.bind(item[position])
        }

        override fun getItemCount() = item.size

    }


    private val recommendationAdapter by lazy { RecommendationAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerRecommendation.adapter = recommendationAdapter
        binding.recyclerRanking.adapter = rankingAdapter
        binding.recyclerContents.adapter = contentsAdapter

        recommendationAdapter.submitList(
            listOf(
                Recommendation(0, "a"),
                Recommendation(1, "a"),
                Recommendation(2, "a"),
                Recommendation(3, "a"),
                Recommendation(4, "a"),
                Recommendation(5, "a"),
                Recommendation(6, "a")
            )
        )
    }

    private class RankingViewHolder(private val binding: ItemRankingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Ranking) {
            with(binding) {
                textTitle.text = item.title
                textGenre.text = item.genre
                textOtt.text = item.ott
                textRunningTime.text = item.runningTime
                textStar.text = item.star.toString()
            }
        }
    }

    private class ContentsViewHolder(private val binding: ItemContentsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Contents) {
            binding.textTitle.text = item.title
        }
    }

    companion object {

        fun newInstance() = HomeFragment()

    }
}