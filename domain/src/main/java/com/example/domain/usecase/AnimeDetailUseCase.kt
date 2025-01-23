package com.example.domain.usecase

import com.example.common.ResponseWrapper
import com.example.domain.repository.AnimeRepository
import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AnimeDetailUseCase{
    suspend fun fetchAnimeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>>
}

class AnimeDetailUseCaseImpl
@Inject
constructor(
    private val repository: AnimeRepository
): AnimeDetailUseCase {
    override suspend fun fetchAnimeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>> {
        return repository.animeDetail(animeId)
    }
}