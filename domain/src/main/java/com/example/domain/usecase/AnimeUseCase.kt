package com.example.domain.usecase

import com.example.common.ResponseWrapper
import com.example.domain.repository.AnimeRepository
import com.example.domain.responseModels.AnimeResponseContainer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AnimeUseCase{
    suspend fun fetchAnime(): Flow<ResponseWrapper<AnimeResponseContainer>>
}

class AnimeUseCaseImpl
@Inject
constructor(
    private val repository: AnimeRepository
): AnimeUseCase {
    override suspend fun fetchAnime(): Flow<ResponseWrapper<AnimeResponseContainer>> {
       return repository.anime()
    }
}