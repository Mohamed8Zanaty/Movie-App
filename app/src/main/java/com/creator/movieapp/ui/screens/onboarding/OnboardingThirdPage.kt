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
import androidx.navigation.NavHostController
import com.creator.movieapp.R
import com.creator.movieapp.ui.navigation.Routes
import com.creator.movieapp.ui.screens.onboarding.components.Carousel
import com.creator.movieapp.ui.screens.onboarding.components.FAB
import com.creator.movieapp.ui.screens.onboarding.components.FloatingBox
import com.creator.movieapp.ui.screens.onboarding.components.TitleAndDesc
import com.creator.movieapp.ui.screens.onboarding.components.slider.OnboardingSlider
import com.creator.movieapp.ui.theme.PageBackground


@Composable
fun OnboardingThirdPage(navHostController: NavHostController) {
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
                Image(
                    painter = painterResource(R.drawable.onboarding3),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    FloatingBox(
                        icon = R.drawable.star,
                        title = "Rating",
                        text = "9 / 10"
                    )
                    Box(modifier = Modifier.padding(20.dp)) {

                        FloatingBox(
                            icon = R.drawable.clock,
                            title = "Duration",
                            text = "1h 20m"
                        )
                    }
                }
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
                OnboardingSlider(number = 3)
                FAB({
                    navHostController.navigate(Routes.Home)
                })
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OnboardingThirdPagePreview() {
//    OnboardingThirdPage()
}