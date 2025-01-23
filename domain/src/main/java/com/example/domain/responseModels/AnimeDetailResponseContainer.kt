package com.example.domain.responseModels

data class AnimeDetailResponseContainer(
    val data: AnimeData
)

data class AnimeData(
    val mal_id: Int,
    val url: String,
    val images: AnimeImages,
    val trailer: Trailer?,
    val approved: Boolean,
    val titles: List<AnimeTitle>,
    val title: String,
    val title_english: String?,
    val title_japanese: String?,
    val title_synonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Int?,
    val status: String,
    val airing: Boolean,
    val aired: Aired,
    val duration: String?,
    val rating: String?,
    val score: Double?,
    val scored_by: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val favorites: Int?,
    val synopsis: String?,
    val background: String?,
    val season: String?,
    val year: Int?,
    val broadcast: Broadcast?,
    val producers: List<Producer>,
    val licensors: List<Licensor>,
    val studios: List<Studio>,
    val genres: List<Genre>,
    val explicit_genres: List<Any>,
    val themes: List<Any>,
    val demographics: List<Demographic>
)

data class AnimeImages(
    val jpg: ImageFormat,
    val webp: ImageFormat
)

data class ImageFormat(
    val image_url: String?,
    val small_image_url: String?,
    val large_image_url: String?
)

data class AnimeTitle(
    val type: String,
    val title: String
)
