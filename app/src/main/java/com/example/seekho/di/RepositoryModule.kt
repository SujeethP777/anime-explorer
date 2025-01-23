package com.example.seekho.di

import com.example.data.datasource.AnimeDatasource
import com.example.data.repository.AnimeRepositoryImpl
import com.example.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUniversitiesRepository(datasource: AnimeDatasource): AnimeRepository =
        AnimeRepositoryImpl(datasource)
}