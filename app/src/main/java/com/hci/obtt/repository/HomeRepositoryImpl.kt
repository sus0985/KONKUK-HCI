package com.hci.obtt.repository

import com.hci.obtt.model.DummyDataPool
import com.hci.obtt.model.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl : HomeRepository {

    override suspend fun getVideoData(): Flow<List<Video>> = flow {
        emit(DummyDataPool.videos)
    }
}