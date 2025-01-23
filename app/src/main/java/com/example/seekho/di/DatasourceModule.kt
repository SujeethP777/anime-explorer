package com.example.seekho.di

import com.example.data.datasource.AnimeDatasource
import com.example.data.datasource.AnimeDatasourceImpl
import com.example.data.network.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    @Singleton
    fun provideAnimeDataSource(networkService: NetworkClient): AnimeDatasource =
        AnimeDatasourceImpl(networkService)
}