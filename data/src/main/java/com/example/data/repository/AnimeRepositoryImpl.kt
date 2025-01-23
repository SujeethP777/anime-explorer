package com.example.data.repository

import com.example.common.ResponseWrapper
import com.example.data.datasource.AnimeDatasource
import com.example.domain.repository.AnimeRepository
import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeRepositoryImpl
@Inject
constructor(
    private val datasource: AnimeDatasource
): AnimeRepository {
    override suspend fun anime(): Flow<ResponseWrapper<AnimeResponseContainer>> =
        datasource.anime()

    override suspend fun animeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>> =
        datasource.animeDetail(animeId)
    }