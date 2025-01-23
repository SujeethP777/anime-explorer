package com.example.data.datasource

import com.example.common.FailureResponseWrapper
import com.example.common.ResponseWrapper
import com.example.common.SuccessResponseWrapper
import com.example.data.network.NetworkClient
import com.example.data.network.NetworkService
import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AnimeDatasource{

    suspend fun anime(): Flow<ResponseWrapper<AnimeResponseContainer>>

    suspend fun animeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>>

}

class AnimeDatasourceImpl
@Inject
constructor(
private val networkClient: NetworkClient
): AnimeDatasource {

    override suspend fun anime(): Flow<ResponseWrapper<AnimeResponseContainer>> {
        val api = networkClient.makeService(NetworkService::class.java)
        return flow {
            val responseWrapper =
                networkClient.execute {
                    api.anime()
                }

            // Handle the success and failure response.
            when (responseWrapper) {
                is SuccessResponseWrapper -> emit(SuccessResponseWrapper(responseWrapper.data))
                is FailureResponseWrapper -> emit(FailureResponseWrapper(responseWrapper.throwable))
                else -> {}
            }
        }
    }

    override suspend fun animeDetail(animeId: Int): Flow<ResponseWrapper<AnimeDetailResponseContainer>> {
        val api = networkClient.makeService(NetworkService::class.java)
        return flow {
            val responseWrapper =
                networkClient.execute {
                    api.animeDetail(animeId)
                }

            // Handle the success and failure response.
            when (responseWrapper) {
                is SuccessResponseWrapper -> emit(SuccessResponseWrapper(responseWrapper.data))
                is FailureResponseWrapper -> emit(FailureResponseWrapper(responseWrapper.throwable))
            }
        }
    }
}