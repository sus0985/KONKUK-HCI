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
            )
        ),
        Video(
            1,
            "안나라수마나라",
            "https://user-images.githubusercontent.com/83066991/167288949-9505409d-375d-404e-9d42-25275a8f9c1e.png",
            4.8f,
            "Netflix",
            "1시간20분/6화",
            "드라마/감동",
            emptyList()
        ),
        Video(
            2,
            "오징어게임",
            "https://user-images.githubusercontent.com/83066991/167288976-e5dd8544-62dc-4353-9920-a99c98c91dd4.png",
            4.9f,
            "Netflix",
            "1시간/16화",
            "드라마/스릴",
            emptyList()
        ),
        Video(
            3,
            "파친코",
            "https://user-images.githubusercontent.com/83066991/167288995-6e3afa5a-12ad-41ce-9786-5d9113b61197.png",
            4.9f,
            "Apple+",
            "1시간/6화",
            "드라마/역사",
            emptyList()
        ),
        Video(
            4,
            "왕좌의 게임",
            "https://user-images.githubusercontent.com/83066991/167289081-d5e53cbb-65a1-43e9-862f-585f0bac92f3.png",
            4.7f,
            "Disney+",
            "1시간/20화",
            "드라마/SF",
            emptyList()
        ),
        Video(
            5,
            "어벤져스",
            "https://user-images.githubusercontent.com/83066991/167289100-2c02dbd7-ef78-4e61-9c61-d2131beff577.png",
            4.5f,
            "Disney+",
            "2시간30분",
            "영화/SF",
            emptyList()
        ),
        Video(
            6,
            "겟 아웃",
            "https://user-images.githubusercontent.com/83066991/167289107-65d79c5b-9fc2-45bf-a31b-c25732ed7bb1.png",
            4.6f,
            "Netflix",
            "1시간40분",
            "영화/공포",
            emptyList()
        ),
        Video(
            7,
            "야차",
            "https://user-images.githubusercontent.com/83066991/167289043-cc234ef4-b731-4755-bbaf-81a1bba9b011.png",
            4.8f,
            "Netflix",
            "2시간",
            "영화/범죄",
            emptyList()
        ),
        Video(
            8,
            "나이트메어 엘리",
            "https://user-images.githubusercontent.com/83066991/167289021-06327b67-0290-47ca-b895-539ee64fa4f8.png",
            4.4f,
            "Seezn",
            "2시간10분",
            "영화/스릴",
            emptyList()
        )
    )
}
