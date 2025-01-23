package com.example.seekho.di

import com.example.domain.repository.AnimeRepository
import com.example.domain.usecase.AnimeDetailUseCase
import com.example.domain.usecase.AnimeDetailUseCaseImpl
import com.example.domain.usecase.AnimeUseCase
import com.example.domain.usecase.AnimeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideAnimeUseCase(repository: AnimeRepository): AnimeUseCase = AnimeUseCaseImpl(repository)

    @Provides
    @Singleton
    fun provideAnimeDetailUseCase(repository: AnimeRepository): AnimeDetailUseCase = AnimeDetailUseCaseImpl(repository)
}