package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hci.obtt.R
import com.hci.obtt.model.ShareData
import com.hci.obtt.ui.main.MainActivity

class ShareActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<ShareData>
    lateinit var imageId : Array<Int>
    lateinit var nickName : Array<String>
    lateinit var ottName : Array<String>
    lateinit var personimg : Array<Int>
    lateinit var personNum : Array<String>
    lateinit var shareText : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn4) as Button
        val gotobtn2 : Button = findViewById<View>(R.id.btn5) as Button

        gotobtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        gotobtn2.setOnClickListener {
            val Intent2 = Intent(this, ShareActivity2::class.java)
            startActivity(Intent2)
        }

        imageId = arrayOf(
            R.drawable.user01,
            R.drawable.user02,
            R.drawable.user03,
            R.drawable.user04
        )

        nickName = arrayOf(
            "핵주먹마블리",
            "넷플릭스처돌이",
            "언젠가칸에가겠어",
            "나의시간은똑바로간다"
        )

        ottName = arrayOf(
            "Netflix",
            "Netflix",
            "Watcha",
            "Disney+"
        )

        personimg = arrayOf(
            R.drawable.ic_person,
            R.drawable.ic_person,
            R.drawable.ic_person,
            R.drawable.ic_person
        )

        personNum = arrayOf(
            "2/4",
            "0/2",
            "1/4",
            "2/2"
        )

        shareText = arrayOf(
            "넷플릭스 스탠다드 요금제 공유하실분?",
            "넷플 프리미엄 선착순 한 분이여!",
            "고전영화 많은 왓차 프리미엄 요금제로 같이 즐겨요!!",
            "디즈니플러스 1년 구독 같이 나눌분 계신가요?"
        )

        newRecyclerView = findViewById(R.id.ShareRecyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ShareData>()
        getUserdata()

        if(intent.hasExtra("ottnamekey") && intent.hasExtra("textmulti")) {
            imageId = imageId.plus(R.drawable.user05)
            nickName = nickName.plus("영화평론은이동진")
            //ottName = ottName.plus(intent.getStringExtra("ottnamekey").toString())
            //shareText = shareText.plus(intent.getStringExtra("textmulti").toString())
            ottName = ottName.plus("Netflix")
            personimg = personimg.plus(R.drawable.ic_person)
            personNum = personNum.plus("0/4")
            shareText = shareText.plus("넷플공유 ㄱㄱ")

            var sharing = ShareData(imageId[4], nickName[4], ottName[4], personimg[4], personNum[4], shareText[4])
            newArrayList.add(sharing)
            newRecyclerView.adapter?.notifyItemInserted(4)
            newRecyclerView.adapter = ShareRecyclerViewAdapter(newArrayList)

        }
    }

    private fun getUserdata() {
        for(i in imageId.indices) {
            val share = ShareData(imageId[i], nickName[i], ottName[i], personimg[i], personNum[i], shareText[i])
            newArrayList.add(share)
        }

        newRecyclerView.adapter = ShareRecyclerViewAdapter(newArrayList)

    }
}