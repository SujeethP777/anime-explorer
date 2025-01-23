package com.example.domain.responseModels


data class AnimeResponseContainer(
    val `data`: List<Data>,
    val pagination: Pagination
)