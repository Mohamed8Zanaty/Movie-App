package com.creator.movieapp.ui.screens.onboarding


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.creator.movieapp.R
import com.creator.movieapp.model.movie.MovieViewModel
import com.creator.movieapp.ui.navigation.Routes

import com.creator.movieapp.ui.screens.onboarding.components.Carousel
import com.creator.movieapp.ui.screens.onboarding.components.FAB
import com.creator.movieapp.ui.screens.onboarding.components.TitleAndDesc
import com.creator.movieapp.ui.screens.onboarding.components.slider.OnboardingSlider
import com.creator.movieapp.ui.theme.PageBackground


@Composable
fun OnboardingSecondPage(viewModel: MovieViewModel, navHostController: NavHostController) {
    val featured by viewModel.featured.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PageBackground)
                .padding(it)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Carousel(
                    images = featured,
                    pageAnimDurationMs = 2000,
                    pauseBetweenPagesMs = 700L
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                TitleAndDesc(
                    "Lorem ipsum dolor sit amet consecteur esplicit",
                    "Semper in cursus magna et eu varius nunc adipiscing. Elementum justo, laoreet id sem semper parturient. "
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OnboardingSlider(number = 2)
                FAB({
                    navHostController.navigate(Routes.Onboarding3)
                })
            }
        }
    }
}
