package com.hci.obtt.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivityVideoDetailBinding
import com.hci.obtt.databinding.ItemActorBinding
import com.hci.obtt.model.Actor
import com.hci.obtt.model.DummyDataPool
import com.hci.obtt.ui.base.BaseActivity

class VideoDetailActivity :
    BaseActivity<ActivityVideoDetailBinding>(R.layout.activity_video_detail) {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.imageVideo.clipToOutline = true

        val id = intent.getIntExtra("id", 0)

        val data = DummyDataPool.videos[id]

        Glide.with(this).load(data.thumbnail).into(binding.imageVideo)

        binding.recyclerActor.adapter = ActorAdapter(DummyDataPool.videos.first().actors)

        with(binding) {

            runningTime.icon.setImageResource(R.drawable.ic_clock)
            runningTime.title.text = "러닝타임"
            runningTime.running.text = data.runningTime

            review.icon.setImageResource(R.drawable.ic_pen)
            review.title.text = "리뷰"
            review.running.text = "226"

            rating.icon.setImageResource(R.drawable.ic_rating)
            rating.title.text = "Rating"
            rating.running.text = "4.5"

            binding.textDesc.text = """죽기 싫다
죽이고 싶지 않다

좀비 바이러스 발생의 시발점이 된 효산고등학교.
이곳에 갇힌 학생들은 필사적으로 탈출구를 찾아야만 한다.

좀비 바이러스가 퍼진 한 고등학교에 고립된 이들과 그들을 구하려는 자들이 한 치 앞을 알 수 없는 극한의 상황을 겪으며 벌어지는 이야기
"""
        }

        binding.buttonBack.setOnClickListener { finish() }

        binding.textInfoMore.setOnClickListener {
            startActivity(Intent(this, ReviewDetailActivity::class.java).apply {
                putExtra("id", id)
            })
        }
    }

    private class ActorAdapter(private val list: List<Actor>) :
        RecyclerView.Adapter<ActorViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
            val binding = ItemActorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ActorViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

    }

    private class ActorViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Actor) {
            Glide.with(binding.root).load(item.image).into(binding.imageActor)
            binding.name.text = item.name
        }
    }
}
