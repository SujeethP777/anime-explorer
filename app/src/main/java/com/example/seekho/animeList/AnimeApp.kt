package com.example.seekho.animeList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun AnimeApp(
  modifier: Modifier = Modifier,
  animeViewModel: AnimeViewModel = hiltViewModel(),
  onAnimeClick: (Int) -> Unit
) {
  val animeState = animeViewModel.anime.collectAsState()

  LaunchedEffect(Unit) {
    animeViewModel.anime()
  }

  LazyColumn(
    modifier = modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    animeState.value?.data?.let { animeList ->
      items(animeList) { anime ->
        AnimeItem(
          title = anime.title,
          episodes = anime.episodes,
          rating = anime.score.toFloat(),
          posterImageUrl = anime.images.jpg.image_url,
          onClick = { onAnimeClick(anime.mal_id)}
        )
        HorizontalDivider(
          modifier = Modifier.padding(vertical = 8.dp),
          color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
          thickness = 2.dp
        )
      }
    }
  }
}

@Composable
fun AnimeItem(
  title: String,
  episodes: Int,
  rating: Float?,
  posterImageUrl: String?,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(8.dp)
      .clickable { onClick() }
  ) {
    AsyncImage(
      model = posterImageUrl,
      contentDescription = title,
      modifier = Modifier
        .size(100.dp)
        .clip(RoundedCornerShape(8.dp)),
      contentScale = ContentScale.Crop
    )

    Spacer(modifier = Modifier.width(16.dp))

    Column(
      verticalArrangement = Arrangement.spacedBy(8.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )

      Text(
        text = "Episodes: $episodes"
      )

      Text(
        text = "Rating: ${rating ?: "N/A"}"
      )
    }
  }
}