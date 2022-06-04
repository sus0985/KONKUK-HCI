package com.hci.obtt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivityReviewDetailBinding
import com.hci.obtt.databinding.ItemReviewBinding
import com.hci.obtt.model.Review
import com.hci.obtt.ui.base.BaseActivity

class ReviewDetailActivity :
    BaseActivity<ActivityReviewDetailBinding>(R.layout.activity_review_detail) {

    private val adapter = ReviewAdapter(
        listOf(
            Review(
                "뭅매니아", 3.7f, """좀비다. “또 좀비야?” 라고 말할 수도 있고 그 좀비들의 
이야기가 이제는 좀 지겨울 수도 있다. 
사실 그동안 등장했던 좀비들의 모습은 천편일률적이
기도 했기에 그런 좀비의 이미지는 그만 보고 싶을 수
도 있다. 죽여도 죽지않고 사람에게 달려들어 사람들ㅇ르
물어뜯는 . 그래..."""
            ),
            Review(
                "잡담리뷰어", 2.3f, """한국 좀비물의 유산을 가져다가 어설프게 재활용한 결과물

뭐 전체적으로 그렂거럭 그냥저냥 재밌게 봤는데... 그래도
실망스러운 건 여전하다. 그래도 재밌게 본 구석도 꽤 많았다. 
일단 나름 신경써서 만든 장면들도 있다는 것이다. 뭐 엄청
참신하다거나 짜릿하거나 쫄리다거나 그런건 아니지만
눈요깃 거리는 된다고 해야하나?..."""
            ),
            Review("스릴러바크", 4.8f, "개잼!!")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.progress.animationDuration = 3000L
        binding.progress.animateProgressChange(94f)
        binding.recycler.adapter = adapter

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }


    private class ReviewAdapter(private val list: List<Review>) :
        RecyclerView.Adapter<ReviewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
            val binding =
                ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ReviewHolder(binding)
        }

        override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

    }

    private class ReviewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(review: Review) {
            binding.textDesc.text = review.desc
            binding.textId.text = review.id
            binding.textStar.text = review.star.toString()
        }
    }
}
