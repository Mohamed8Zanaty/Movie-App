package com.creator.movieapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.creator.movieapp.model.movie.MovieViewModel
import com.creator.movieapp.ui.screens.homescreen.HomeScreen
import com.creator.movieapp.ui.screens.onboarding.OnboardingFirstPage
import com.creator.movieapp.ui.screens.onboarding.OnboardingSecondPage
import com.creator.movieapp.ui.screens.onboarding.OnboardingThirdPage
import com.creator.movieapp.ui.screens.splashscreen.SplashScreen

@Composable
fun NavigationSystem(vm: MovieViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash,
    ) {
        composable(Routes.Splash) { SplashScreen(navController) }
        composable(Routes.Onboarding1) { OnboardingFirstPage(navController) }
        composable(Routes.Onboarding2) { OnboardingSecondPage(viewModel = vm, navController) }
        composable(Routes.Onboarding3) { OnboardingThirdPage(navController) }
        composable(Routes.Home) {
            HomeScreen(viewModel = vm, navController)
        }
    }
}