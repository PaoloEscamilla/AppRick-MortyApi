package com.example.rickmortyapp_paolo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickmortyapp_paolo.screens.CharacterListScreen
import com.example.rickmortyapp_paolo.screens.CharacterDetailScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "character_list") {
        composable("character_list") {
            CharacterListScreen(onCharacterClick = { character ->
                navController.navigate("character_detail/${character.id}")
            })
        }
        composable("character_detail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
            CharacterDetailScreen(characterId)
        }
    }
}
