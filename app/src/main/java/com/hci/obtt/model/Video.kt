package com.hci.obtt.model

import java.io.Serializable

data class Video(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val star: Float,
    val ott: String,
    val runningTime: String,
    val genre: String,
    val actors: List<Actor>,
) : Serializable
