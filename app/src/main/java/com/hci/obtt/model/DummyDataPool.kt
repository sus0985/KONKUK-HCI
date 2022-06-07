package com.hci.obtt.model

object DummyDataPool {

    fun getVideoById(id: Int): Video {
        return if (id < 0) videos.first()
        else if (id > videos.size) videos.last()
        else videos[id]
    }

    val videos = listOf(
        Video(
            0,
            "지금 우리 학교는",
            "https://user-images.githubusercontent.com/83066991/167288964-619ccab6-97b4-41ee-a03b-462738c52ccb.png",
            4.9f,
            "Netflix",
            "1시간/6화",
            "드라마/호러",
            listOf(
                Actor(
                    "박지후",
                    "https://user-images.githubusercontent.com/83066991/168604157-8c980696-b0f4-40a6-927d-92abfc273310.png"
                ),
                Actor(
                    "윤찬영",
                    "https://user-images.githubusercontent.com/83066991/168604223-f91e77a5-7194-4480-a480-5aff9bae442a.png"
                ),
                Actor(
                    "조이현",
                    "https://user-images.githubusercontent.com/83066991/168604259-497c64a8-d624-4719-81bd-63a53721d8db.png"
                ),
                Actor(
                    "로몬",
                    "https://user-images.githubusercontent.com/83066991/168604309-be91cd0b-3405-487f-9639-174fd791fd73.png"
                ),
                Actor(
                    "유인수",
                    "https://user-images.githubusercontent.com/83066991/168604359-ba080794-6c4a-400c-ac65-cdfbdd7106a9.png"
                ),
                Actor(
                    "이유미",
                    "https://user-images.githubusercontent.com/83066991/168604410-94879be9-154d-43e5-8dee-e0e2aee34d94.png"
                ),
            ),
            """죽기 싫다
|죽이고 싶지 않다

|좀비 바이러스 발생의 시발점이 된 효산고등학교.
|이곳에 갇힌 학생들은 필사적으로 탈출구를 찾아야만 한다.

|좀비 바이러스가 퍼진 한 고등학교에 고립된 이들과 그들을 구하려는 자들이 한 치 앞을 알 수 없는 극한의 상황을 겪으며 벌어지는 이야기
""".trimMargin()
        ),
        Video(
            1,
            "안나라수마나라",
            "https://user-images.githubusercontent.com/83066991/167288949-9505409d-375d-404e-9d42-25275a8f9c1e.png",
            4.8f,
            "Netflix",
            "1시간20분/6화",
            "드라마/감동",
            listOf(
                Actor(
                    "김혜은",
                    "https://user-images.githubusercontent.com/39792638/172469559-543c5c33-0115-4cf8-960f-22237462a963.jpg"
                ),
                Actor(
                    "남다름",
                    "https://user-images.githubusercontent.com/39792638/172469565-6c4da6a6-7c45-4e65-892f-cf6e69bba211.jpg"
                ),
                Actor(
                    "지창욱",
                    "https://user-images.githubusercontent.com/39792638/172469568-9966c6ab-66a5-4177-8a8e-51ef14d46a9f.jpg"
                ),
                Actor(
                    "지혜원",
                    "https://user-images.githubusercontent.com/39792638/172469572-c213dd42-2afa-4d15-a1f0-87d502e8cecf.jpg"
                ),
                Actor(
                    "최성은",
                    "https://user-images.githubusercontent.com/39792638/172469574-cc9513b1-f078-43a2-8e38-d122d695db34.jpg"
                ),
                Actor(
                    "황인엽",
                    "https://user-images.githubusercontent.com/39792638/172469576-516dcb86-4098-4ee9-a9b8-f3d1f15328ed.jpg"
                ),
            ),
            """따뜻한 감성의 하일권 작가 2010 작품.
                    |철없는 마술사를 만난 한 소녀의 성장 드라마.
                    |당신, 마술을 믿으시나요?""".trimMargin()
        ),
        Video(
            2,
            "오징어게임",
            "https://user-images.githubusercontent.com/83066991/167288976-e5dd8544-62dc-4353-9920-a99c98c91dd4.png",
            4.9f,
            "Netflix",
            "1시간/16화",
            "드라마/스릴",
            listOf(
                Actor(
                    "공유",
                    "https://user-images.githubusercontent.com/39792638/172469577-cf4ca527-2766-4199-bba6-8e1c7c4d2a3b.jpg"
                ),
                Actor(
                    "박해수",
                    "https://user-images.githubusercontent.com/39792638/172469579-14a95417-388b-4c07-b572-01e645c3720e.jpg"
                ),
                Actor(
                    "위하준",
                    "https://user-images.githubusercontent.com/39792638/172469583-c87ee443-8ef8-4c79-b8af-b85e8f01f932.jpg"
                ),
                Actor(
                    "이유미",
                    "https://user-images.githubusercontent.com/39792638/172469586-a99e574f-8e8d-44d0-a91c-9b39d709b2f6.jpg"
                ),
                Actor(
                    "이정재",
                    "https://user-images.githubusercontent.com/39792638/172469588-f10951b8-28e6-4190-a3a8-9252960809f4.jpg"
                ),
                Actor(
                    "정호연",
                    "https://user-images.githubusercontent.com/39792638/172469592-e46776bd-9e71-4c54-bfd1-b9c43d0a16b3.jpg"
                ),
            ),
            """456억 원의 상금이 걸린 의문의 서바이벌에 참가한 사람들이 최후의 승자가 되기 위해 목숨을 걸고 극한의 게임에 도전하는 이야기를 담은 
                |넷플릭스 시리즈
                |빚에 쫓기는 수백 명의 사람들이 서바이벌 게임에 뛰어든다. 
                |거액의 상금으로 새로운 삶을 시작하기 위해. 하지만 모두 승자가 될 순 없는 법. 탈락하는 이들은 끔찍한 결과를 각오해야 한다.""".trimMargin()
        ),
        Video(
            3,
            "파친코",
            "https://user-images.githubusercontent.com/83066991/167288995-6e3afa5a-12ad-41ce-9786-5d9113b61197.png",
            4.9f,
            "Apple+",
            "1시간/6화",
            "드라마/역사",
            listOf(
                Actor(
                    "김민하",
                    "https://user-images.githubusercontent.com/39792638/172469611-24f55379-d06a-435d-b7f6-bfdc886db17a.jpg"
                ),
                Actor(
                    "안나 사웨이",
                    "https://user-images.githubusercontent.com/39792638/172469613-3056fad4-2a4b-41f4-9bf9-a4ced2015704.jpg"
                ),
                Actor(
                    "윤여정",
                    "https://user-images.githubusercontent.com/39792638/172469616-22eecc00-4322-4a50-96c7-5061a4195a43.jpg"
                ),
                Actor(
                    "이민호",
                    "https://user-images.githubusercontent.com/39792638/172469619-94446d91-7b42-4b9d-bea0-428fb6dd5c3e.jpg"
                ),
                Actor(
                    "정은채",
                    "https://user-images.githubusercontent.com/39792638/172469624-b644d186-8917-4ed4-bfc4-4e76a01e3389.jpg"
                ),
                Actor(
                    "진하",
                    "https://user-images.githubusercontent.com/39792638/172469626-05c4e032-b797-4776-a5e7-cf4227efe78c.jpg"
                ),
            ),
            """뉴욕타임스 베스트셀러에 선정된 동명의 소설을 원작으로 한 Apple Original 시리즈 ‘파친코’ - Pachinko. 
                |고국을 떠나 억척스럽게 생존과 번영을 추구하는 한인 이민 가족 4대의 삶과 꿈을 그려낸 대하드라마. 
                |아카데미 여우조연상 수상에 빛나는 윤여정과 더불어 이민호, 진 하, 김민하 등 출연.""".trimMargin()
        ),
        Video(
            4,
            "왕좌의 게임 시즌8",
            "https://user-images.githubusercontent.com/83066991/167289081-d5e53cbb-65a1-43e9-862f-585f0bac92f3.png",
            4.7f,
            "Disney+",
            "1시간/20화",
            "드라마/SF",
            listOf(
                Actor(
                    "그웬돌린 크리스티",
                    "https://user-images.githubusercontent.com/39792638/172469596-9210481d-8d2d-4cb9-bdb4-0150ef2968ef.jp"
                ),
                Actor(
                    "메이지 윌리엄스",
                    "https://user-images.githubusercontent.com/39792638/172469597-d43068a8-8894-487f-ba80-14857f596995.jpg"
                ),
                Actor(
                    "소피 터너",
                    "https://user-images.githubusercontent.com/39792638/172469600-65212aeb-9a23-47a7-8e91-e543410c6b2e.jpg"
                ),
                Actor(
                    "에밀리아 클라크",
                    "https://user-images.githubusercontent.com/39792638/172469602-380261c4-c7e3-4a22-803f-888bdb63cfb7.jpg"
                ),
                Actor(
                    "킷 해링턴",
                    "https://user-images.githubusercontent.com/39792638/172469606-a319a484-7b93-4175-be94-3f6f906ad3e2.jpg"
                ),
                Actor(
                    "피터 딘클리지",
                    "https://user-images.githubusercontent.com/39792638/172469608-bd1371e8-16b5-47f4-ae1d-f42b0c6eee3f.jpg"
                ),
            ),
            """수십 년간 이어진 여름, 하지만 이제 끝나지 않을 겨울이 다가온다.
|철왕좌를 차지하기 위한 피의 서사시""".trimMargin()
        ),
        Video(
            5,
            "어벤져스",
            "https://user-images.githubusercontent.com/83066991/167289100-2c02dbd7-ef78-4e61-9c61-d2131beff577.png",
            4.5f,
            "Disney+",
            "2시간30분",
            "영화/SF",
            emptyList(),
            """"""
        ),
        Video(
            6,
            "겟 아웃",
            "https://user-images.githubusercontent.com/83066991/167289107-65d79c5b-9fc2-45bf-a31b-c25732ed7bb1.png",
            4.6f,
            "Netflix",
            "1시간40분",
            "영화/공포",
            emptyList(),
            """"""
        ),
        Video(
            7,
            "야차",
            "https://user-images.githubusercontent.com/83066991/167289043-cc234ef4-b731-4755-bbaf-81a1bba9b011.png",
            4.8f,
            "Netflix",
            "2시간",
            "영화/범죄",
            emptyList(),
            """"""
        ),
        Video(
            8,
            "나이트메어 엘리",
            "https://user-images.githubusercontent.com/83066991/167289021-06327b67-0290-47ca-b895-539ee64fa4f8.png",
            4.4f,
            "Seezn",
            "2시간10분",
            "영화/스릴",
            emptyList(),
            """"""
        )
    )
}
