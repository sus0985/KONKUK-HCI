package com.hci.obtt.ui.tab.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentHomeBinding
import com.hci.obtt.databinding.ItemContentsBinding
import com.hci.obtt.databinding.ItemRankingBinding
import com.hci.obtt.model.Contents
import com.hci.obtt.model.Video
import com.hci.obtt.ui.base.BaseFragment
import com.hci.obtt.ui.main.MainActivity
import com.hci.obtt.ui.tab.TabViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by activityViewModels<TabViewModel>()
    private val rankingAdapter = object : RecyclerView.Adapter<RankingViewHolder>() {

        private var item = listOf<Video>()

        fun setList(list: List<Video>) {
            item = list
            notifyItemRangeChanged(0, list.size)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
            val binding =
                ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RankingViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
            holder.bind(item[position], (requireActivity() as MainActivity)::goToVideoDetail)
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
            val binding =
                ItemContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ContentsViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ContentsViewHolder, position: Int) {
            holder.bind(item[position], position)
        }

        override fun getItemCount() = item.size

    }

    private val recommendationAdapter by lazy { RecommendationAdapter((requireActivity() as MainActivity)::goToVideoDetail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerRecommendation.adapter = recommendationAdapter
            recyclerRanking.adapter = rankingAdapter
            recyclerContents.adapter = contentsAdapter

            imageViewSpotLight.clipToOutline = true
            Glide.with(imageViewSpotLight)
                .load("https://user-images.githubusercontent.com/83066991/167290386-55bb769f-607a-485d-ac9b-8210057a9f2b.png")
                .into(imageViewSpotLight)

            editTextSearch.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            }
        }

        lifecycleScope.launch {
            viewModel.getVideoData().collect {
                recommendationAdapter.submitList(it)
            }
        }

        lifecycleScope.launch {
            viewModel.getVideoData().collect {
                rankingAdapter.setList(it)
            }
        }
    }

    private class RankingViewHolder(private val binding: ItemRankingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Video, onClick: (Int) -> Unit) {
            with(binding) {
                root.setOnClickListener { onClick(item.id) }
                imageThumbnail.clipToOutline = true
                Glide.with(imageThumbnail).load(item.thumbnail).into(imageThumbnail)
                textTitle.text = item.title
                textGenre.text = item.genre
                textOtt.text = item.ott
                textRunningTime.text = item.runningTime
                textStar.text = item.star.toString()
            }
        }
    }

    private inner class ContentsViewHolder(private val binding: ItemContentsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Contents, position: Int) {
            binding.textTitle.text = item.title

            binding.root.setOnClickListener {
                when (position) {
                    0 -> (requireActivity() as MainActivity).goToRandomRecommend()
                    1 -> (requireActivity() as MainActivity).goToRecommendedByAge()
                    2 -> (requireActivity() as MainActivity).goToShare()
                    3 -> (requireActivity() as MainActivity).goToCustomerService()
                    else -> Unit
                }
            }
        }
    }

    companion object {

        fun newInstance() = HomeFragment()

    }
}
