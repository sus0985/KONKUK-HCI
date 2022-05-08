package com.hci.obtt.model

data class Ranking(
    val id: Int,
    val ranking: Int,
    val title: String,
    val ott: String,
    val runningTime: String,
    val genre: String,
    val star: Float
)