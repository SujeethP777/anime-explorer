package com.example.seekho.animeDetail

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.seekho.animeList.AnimeViewModel

@Composable
fun AnimeDetail(
    modifier: Modifier = Modifier,
    animeId: Int,
    animeDetailViewModel: AnimeDetailViewModel = hiltViewModel(),
) {
    val animeDetailState = animeDetailViewModel.animeDetail.collectAsState()

    LaunchedEffect(animeId) {
        animeDetailViewModel.animeDetail(animeId)
    }

    animeDetailState.value?.let { animeDetail ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (!animeDetail.data.trailer?.url.isNullOrEmpty()) {
                animeDetail.data.trailer?.let { AnimeTrailerPlayer(videoId = it.youtube_id, lifecycleOwner = LocalLifecycleOwner.current) }
            } else {
                Image(
                    painter = rememberAsyncImagePainter(animeDetail.data.images.jpg.large_image_url),
                    contentDescription = "Anime Poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = animeDetail.data.title,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = animeDetail.data.synopsis ?: "No synopsis available.",
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Genres: ${
                    animeDetail.data.genres.takeIf { it.isNotEmpty() }?.joinToString(", ") { it.name }
                        ?: "N/A"
                }",
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Main Cast: ${
                    animeDetail.data.producers.takeIf { it.isNotEmpty() }?.joinToString(", ") { it.name }
                        ?: "N/A"
                }",
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Episodes: ${animeDetail.data.episodes ?: "N/A"}",
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rating: ${animeDetail.data.score ?: "N/A"}",
            )
        }
    } ?: run {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            CircularProgressIndicator()
        }
    }
}