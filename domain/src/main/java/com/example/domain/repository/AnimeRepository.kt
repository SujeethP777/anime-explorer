package com.example.domain.repository

import com.example.common.ResponseWrapper
import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    suspend fun anime(): Flow<ResponseWrapper<AnimeResponseContainer>>

    suspend fun animeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>>

}