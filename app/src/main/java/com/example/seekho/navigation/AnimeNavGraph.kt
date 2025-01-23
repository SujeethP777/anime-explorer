package com.example.seekho.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.seekho.animeDetail.AnimeDetail
import com.example.seekho.animeList.AnimeApp

@Composable
fun AnimeNavGraph(
    modifier: Modifier = Modifier,
    startDestination: String = "anime_list"
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("anime_list") {
            AnimeApp(
                modifier = modifier,
                onAnimeClick = { animeId ->
                    navController.navigate("anime_detail/$animeId")
                }
            )
        }

        composable(
            route = "anime_detail/{animeId}",
            arguments = listOf(navArgument("animeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val animeId = backStackEntry.arguments?.getInt("animeId") ?: 0
            AnimeDetail(
                modifier = modifier,
                animeId = animeId
            )
        }
    }
}
