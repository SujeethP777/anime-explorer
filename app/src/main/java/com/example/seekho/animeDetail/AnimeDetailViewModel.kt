package com.example.seekho.animeDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.FailureResponseWrapper
import com.example.common.SuccessResponseWrapper
import com.example.domain.responseModels.AnimeDetailResponseContainer
import com.example.domain.responseModels.AnimeResponseContainer
import com.example.domain.usecase.AnimeDetailUseCase
import com.example.domain.usecase.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel
@Inject
constructor(
    private val animeDetailUseCase: AnimeDetailUseCase
): ViewModel(){

    private val _animeDetail = MutableStateFlow<AnimeDetailResponseContainer?>(null)
    val animeDetail: StateFlow<AnimeDetailResponseContainer?> get() = _animeDetail


    fun animeDetail(animeId: Int){
        viewModelScope.launch {
            animeDetailUseCase.fetchAnimeDetail(animeId)
                .collect {
                    when (it) {
                        is SuccessResponseWrapper -> {
                            _animeDetail.value = it.data
                        }
                        is FailureResponseWrapper -> Log.d("AnimeDetailViewModel", it.throwable.toString())
                    }
                }
        }
    }
}