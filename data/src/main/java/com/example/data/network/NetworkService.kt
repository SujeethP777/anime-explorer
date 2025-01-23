package com.example.data.network

import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("v4/top/anime")
    suspend fun anime(): Response<AnimeResponseContainer>

    @GET("v4/anime/{anime_id}")
    suspend fun animeDetail(
        @Path("anime_id") animeId: Int
    ): Response<AnimeDetailResponseContainer>
}