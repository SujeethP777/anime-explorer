package com.example.seekho.animeList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.FailureResponseWrapper
import com.example.common.SuccessResponseWrapper
import com.example.domain.responseModels.AnimeResponseContainer
import com.example.domain.usecase.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel
@Inject
constructor(
    private val animeUseCase: AnimeUseCase
): ViewModel(){

    private val _anime = MutableStateFlow<AnimeResponseContainer?>(null)
    val anime: StateFlow<AnimeResponseContainer?> get() = _anime


    fun anime(){
        viewModelScope.launch {
            animeUseCase.fetchAnime()
                .collect {
                    when (it) {
                        is SuccessResponseWrapper -> {
                            _anime.value = it.data
                        }
                        is FailureResponseWrapper -> Log.d("AnimeViewModel", it.throwable.toString())
                    }
                }
        }
    }
}
