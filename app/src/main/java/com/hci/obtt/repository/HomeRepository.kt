package com.hci.obtt.repository

import com.hci.obtt.model.Video
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getVideoData(): Flow<List<Video>>
}