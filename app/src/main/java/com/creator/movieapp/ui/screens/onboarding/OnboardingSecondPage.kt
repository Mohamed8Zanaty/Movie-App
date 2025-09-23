package com.creator.movieapp.ui.screens.onboarding

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.creator.movieapp.R
import com.creator.movieapp.ui.screens.onboarding.components.Carousel
import com.creator.movieapp.ui.screens.onboarding.components.FAB
import com.creator.movieapp.ui.screens.onboarding.components.TitleAndDesc
import com.creator.movieapp.ui.screens.onboarding.components.slider.OnboardingSlider
import com.creator.movieapp.ui.theme.PageBackground

val movies = listOf(
    R.drawable.movie_test,
    R.drawable.movie_test,
    R.drawable.movie_test,
)

@Composable
fun OnboardingSecondPage(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(PageBackground)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Carousel(
                    images = movies,
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
                FAB({})
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OnboardingSecondPagePreview() {
    OnboardingSecondPage()
}