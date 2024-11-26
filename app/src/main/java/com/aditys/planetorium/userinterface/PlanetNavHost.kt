package com.aditys.planetorium.userinterface

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun PlanetNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "planetList") {
        composable("planetList") {
            PlanetListScreen(navController = navController)
        }
        composable("planetDetail/{planetName}") { backStackEntry ->
            PlanetDetailScreen(planetName = backStackEntry.arguments?.getString("planetName") ?: "")
        }
    }
}

