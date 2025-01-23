# Anime Explorer App

## Description

This is an Android app that displays a list of top anime and allows users to view detailed information about each anime, including trailers (if available), cast, genres, ratings, and more.
The app fetches anime data from an API and provides an interactive user experience with Jetpack Compose for UI, MVVM architecture and Hilt for dependency injection.

## Features

### Anime List Screen
- Displays a list of top anime with their titles and thumbnail images.
- Users can click on any anime to view more detailed information about it on the Anime Detail Screen.

### Anime Detail Screen
- Displays detailed information about a selected anime:
  - **Trailer**: Plays the anime's trailer using ExoPlayer or YouTube player (if available).
  - **Title**: Displays the anime’s title.
  - **Genres**: Displays a comma-separated list of genres associated with the anime.
  - **Main Cast**: Lists the main cast for the anime (if available).
  - **Rating**: Displays the anime’s rating (if available).
  - **Episodes**: Displays the number of episodes for the anime.
  - **Synopsis**: Shows a brief description or synopsis of the anime.

## Assumptions

- The app retrieves data from an external API (e.g., Jikan API, MyAnimeList API) to display a list of top anime.
- The anime trailer (if available) will be fetched from YouTube platform.
- The anime details page is loaded when the user clicks on any anime in the list.
